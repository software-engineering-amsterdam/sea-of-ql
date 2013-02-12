@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::JS

import IO;
import String;
import lang::ql::ast::AST;
import lang::ql::compiler::web::JSExpressionPrinter;

import util::ValueUI; 

private str BLOCK = "Block";
private loc JS_SRC_LOC = |project://QL-R-kemi/js/|;

public void JS(Form f, loc dest) {
  for(js <- listEntries(JS_SRC_LOC))
    writeFile(dest + js, readFile(JS_SRC_LOC + js));

  writeFile(dest + "styling.js", "function styling() { }");
  
  dest += "checking.js";
  
  writeFile(dest, JS(f));
}

private str showElement(str name) =
  "show($(\"#<name><BLOCK>\"));";

private str hideElement(str name) =
  "hide($(\"#<name><BLOCK>\"));";

private str assignVar(str ident) =
  "var <ident> = getFormValue(\"#<ident>\");";
  
private set[str] getDirectDescendingIdents(Statement cond) {
  list[Statement] items = cond.ifPart.body;
  
  for(ei <- cond.elseIfs)
    items += ei.body;

  for(ep <- cond.elsePart)
    items += ep.body;
  
  return getDirectDescendingIdents(items);
}

private set[str] getDirectDescendingIdents(list[Statement] items) =
  {q.answerIdentifier.ident | i <- items, question(Question q) := i};
  
private set[str] getConditionalVariableMembers(Statement cond) =
  {
    name | 
    /x:ident(name) <- 
      [cond.ifPart.condition] + 
      [x.condition | x <- cond.elseIfs]
   };

private str JS(Form f) =
  "// THIS IS AN AUTOMATICALLY GENERATED FILE. DO NOT EDIT!
  '
  'function validate<f.formName.ident>() {
  '
  '  $(\"#<f.formName.ident>\").validate({
  '    rules: {
  '      <createValidationRules(f)>
  '    }
  '  });
  '
  '  $(\"#<f.formName.ident>\").on(\"input\", function(evt) {
  '    $(evt.target).valid();
  '  });
  '
  '  // Make sure all elements are properly styled before registering events
  '  styling();
  '
  '  // The code to automatically generate calculated fields 
  '  <calculatedFields(f)>
  '
  '  // End with control flow functionality for branches etc. 
  '  <conditionalVisibility(f)>
  '}
  ";
  
private str calculatedFields(Form f) {
  list[tuple[Type \type, str ident, Expr expr]] cfs = [];
  
  int cbcounter = 0;
  
  top-down visit(f) {
    case q: question(_, t, i, e): cfs += [<t, i.ident, e>];
  }
  
  str ret = "";
  for(c <- cfs) {
    ret += "<individualCalculatedField(cbcounter, c.\type, c.ident, c.expr)>";
    cbcounter += 1;
  }
  return ret;
}
  
private str individualCalculatedField(int cnt, Type \type, str ident, Expr expr) {  
  list[str] eidents = [];
  
  top-down visit(expr) {
    case Expr e: ident(str name): eidents += name;
  }

  return "
    '<for(e <- eidents) {>
    '$(\"#<e>\").on(\"input change\", calc_callback_<cnt>);
    '<}>
    '
    'function calc_callback_<cnt>(e) {
    '  var result; 
    '<for(e <- eidents) {>
    '  <assignVar(e)>
    '<}>
    '  result = <jsPrint(expr)>;
    '<if(\type == moneyType("money")){>
    '  setFormValue(\"#<ident>\", roundMoney(result));
    '<} else {>
    '  setFormValue(\"#<ident>\", result);
    '<}>
    '}
    ";
}  

private str createValidationRules(Form f) {
  list[tuple[str ident, Type \type]] rules = [];
  
  top-down visit(f) {
    case q: question(_, t, i): rules += [<i.ident, t>];
    case q: question(_, t, i, _): rules += [<i.ident, t>];
  }
  
  return "<for (r <- rules) {>
    '<r.ident>: {
    '  <getTypeRule(r.\type)>
    '},
    '<}>";
}


private str getTypeRule(Type t: integerType(_)) =
  "required: true,
  'digits: true
  ";

private str getTypeRule(Type t: dateType(_)) =
  "required: true,
  'date: true
  ";

private str getTypeRule(Type t: moneyType(_)) =
  "required: true,
  'number: true,
  'moneyValidator: true
  ";

private str getTypeRule(Type t: stringType(_)) =
  "required: true,
  ";

private str getTypeRule(Type t: booleanType(_)) =
  "required: true
  ";

private str conditionalVisibility(Form f) {
  list[Statement] conditionals = [];

  int cbcounter = 0;
  
  top-down visit(f) {
    case c: ifCondition(_, _, _): conditionals += c;
  }
  
  str ret = "
    '// Hide all elements in a conditional branch on page load 
    '<for(i <- [id | c <- conditionals, /u:identDefinition(str id) <- c]) {>
    '<hideElement(i)>
    '<}>
    ";
  
  for(c <- conditionals) {
    ret += "
    '<individualConditional(cbcounter, c)>
    '";
    cbcounter += 1;
  }
  
  return ret;
}

private str individualConditional(int suffix, Statement cond) {
  str ret = "";

  cbs = getConditionalVariableMembers(cond);
  qs = getDirectDescendingIdents(cond);
  
  for(cb <- cbs) {
    ret += "
    '$(\"#<cb>\").on(\"input change\", callback_<suffix>);
    ";
  }
  
  ret += "
  'function callback_<suffix>(e) {
  '  <for(cb <- cbs) {>
  '  <assignVar(cb)>
  '  <}>
  '  <for(q <- qs) {>
  '  <hideElement(q)>
  '  <}>
  '  <individualConditionalVisibility(cond)>
  '}
  ";

  return ret;
}

private str individualConditionalVisibility(Statement item: 
    ifCondition(Conditional ifPart, list[Conditional] elseIfs, 
    list[ElsePart] elsePart)) =
  "if(<jsPrint(ifPart.condition)>) { 
  '<for(e <- getDirectDescendingIdents(ifPart.body)) {>
  '  <showElement(e)>
  '<}>
  '
  '<for(ei <- elseIfs) { >
  '} else if(<jsPrint(ei.condition)>) { 
  '  <for(e <- [id | /u:identDefinition(str id) <- ei.body]) {>
  '    <showElement(e)>
  '  <}>
  '<}>
  '
  '<for(ep <- elsePart) { >
  '} else { 
  '  <for(e <- [id | /u:identDefinition(str id) <- ep.body]) {>
  '    <showElement(e)>    
  '  <}>
  '<}>
  '}";
