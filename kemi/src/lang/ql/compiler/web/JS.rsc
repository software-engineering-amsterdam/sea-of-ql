module lang::ql::compiler::web::JS

import IO;
import String;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;

import util::ValueUI; 

private str BLOCK = "Block";

public void JS(Form f, loc dest) {
  dest += "checking.js";
  
  writeFile(dest, "");
  appendToFile(dest, JS(f));
}

private str showElement(str name) =
  "$(\"#<name><BLOCK>\").show();";

private str hideElement(str name) =
  "$(\"#<name><BLOCK>\").hide();";

private str assignVar(str ident) =
  "var <ident>;
  'if($(\"#<ident>\").val() == \"true\") {
  '  <ident> = true;
  '} else if($(\"#<ident>\").val() == \"false\") {
  '  <ident> = false;
  '} else {
  '  <ident> = $(\"#<ident>\").val();;
  '}";
  
private list[str] getDirectDescendingIdents(Statement cond) {
  list[Statement] items = cond.ifPart.body;
  
  for(ei <- cond.elseIfs) {
    items += ei.body;
  }

  for(ep <- cond.elsePart) {
    items += ep.body;
  }
  
  return getDirectDescendingIdents(items);
}

private list[str] getDirectDescendingIdents(list[Statement] items) =
  [q.answerIdentifier.ident | i <- items, question(Question q) := i];
  
private list[str] getConditionalVariableMembers(Statement cond) =
  [name | /x:ident(name) <- [cond.ifPart.condition] + [x.condition | x <- cond.elseIfs]];

private str JS(Form f) =
  " \<!-- THIS IS AN AUTOMATICALLY GENERATED FILE. DO NOT EDIT!--\>
  'function validate<f.formName.ident>() {
  '  $(\"#<f.formName.ident>\").validate({
  '    rules: {
  '      <createValidationRules(f)>
  '    }
  '  });
  '
  '  \<!-- The code to automatically generate calculated fields --\>
  '  <calculatedFields(f)>
  '
  '  \<!-- End with control flow functionality for branches etc. --\>
  '  <conditionalVisibility(f)>
  '}
  ";
  
private str calculatedFields(Form f) {
  list[tuple[str ident, Expr expr]] cfs = [];
  
  top-down visit(f) {
    case q: question(_, _, i, e): cfs += [<i.ident, e>];
  }
  
  return "<for(c <- cfs) {>
  '<individualCalculatedField(f.formName.ident, c)>
  '<}>";
}
  
private str individualCalculatedField(str form, tuple[str ident, Expr expr] cf) {  
  list[str] eidents = [];
  
  top-down visit(cf.expr) {
    case Expr e: ident(str name): eidents += name;
  }

  return "
  '$(\"#<form>\").change(function(e)  {
  '  var result; 
  '<for(e <- eidents) {>
  '  <assignVar(e)>
  '<}>
  '  result = <prettyPrint(cf.expr)>;
  '  $(\"#<cf.ident>\").val(result);  
  '});
  ";
}  

private str createValidationRules(Form f) {
  list[tuple[str ident, str \type]] rules = [];
  
  top-down visit(f) {
    case q: question(_, t, i): rules += [<i.ident, t.name>];
    case q: question(_, t, i, _): rules += [<i.ident, t.name>];
  }
  
  return "<for (r <- rules) {>
  '<r.ident>: {
  '  required: true,
  '  <getTypeRule(r.\type)>: true
  '},
  '<}>";
}

private str getTypeRule(str t) {
  switch(t) {
    case "integer": return "digits";
    case "date": return "date";
    case "money": return "number";
    case "string": return "required";
    case "boolean": return "required";
  }
}

private str conditionalVisibility(Form f) {
  list[Statement] conditionals = [];

  int cbcounter = 0;
  
  top-down visit(f) {
    case c: ifCondition(_, _, _):
      conditionals += c;
  }
  
  str ret = "
  '\<!-- Hide all elements in a conditional branch on page load --\>
  '<for(i <- [id | c <- conditionals, /u:identDefinition(str id) <- c]) {>
  '  <hideElement(i)>
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
    '$(\"#<cb>\").click(callback_<suffix>);
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
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) =
    "if(<prettyPrint(ifPart.condition)>) { 
    '<for(e <- getDirectDescendingIdents(ifPart.body)) {>
    '  <showElement(e)>
    '<}>
    '
    '<for(ei <- elseIfs) { >
    '} else if(<prettyPrint(ei.condition)>) { 
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
