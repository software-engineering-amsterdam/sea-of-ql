module lang::ql::compiler::web::JS

import IO;
import String;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter; 

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
  'if($(\"#<ident>\").attr(\"type\") == \"checkbox\") {
  '  <ident> = $(\"#<ident>\").is(\":checked\");
  '} else {
  '  <ident> = $(\"#<ident>\").val();;
  '}";

private str JS(Form f) =
  "function validate<f.formName.ident>() {
  '  $(\"#<f.formName.ident>\").validate({
  '    rules: {
  '      <createValidationRules(f)>
  '    }
  '  });
  '
  '  <calculatedFields(f)>
  '
  '  <conditionalVisibility(f)>
  '}
  ";
  
private str conditionalVisibility(Form f) {
  list[Statement] conditionals = [];
  
  top-down visit(f) {
    case c: ifCondition(_, _, _): 
      conditionals += c;
  }

  return "
  '\<!-- Hide all elements in a conditional branch on page load --\>
  '<for(i <- [id | c <- conditionals, /u:identDefinition(str id) <- c]) {>
  '  <hideElement(i)>
  '<}>
  '
  ' \<!-- Declare callback function to do evaluation of conditionals --\>
  '$(\"#<f.formName.ident>\").change(function(e)  {
  '<for(e <- {name | /u:ident(str name) <- f}) {>
  '  <assignVar(e)>
  '<}>
  '
  ' \<!-- Hide all the conditionals on evaluation --\>
  '<for(i <- [id | c <- conditionals, /u:identDefinition(str id) <- c]) {>
  '  <hideElement(i)>
  '<}>
  '
  ' \<!-- Generate the conditional branches vor visibility --\>
  '<for(c <- conditionals) {>
  '  <individualConditionalVisibility(c)>
  '<}>
  '});";
}



private str individualConditionalVisibility(Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) =
    "if(<prettyPrint(ifPart.condition)>) { 
    '<for(e <- [id | /u:identDefinition(str id) <- ifPart.body]) {>
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

private str calculatedFields(Form f) {
  list[tuple[str ident, Expr expr]] cfs = [];
  
  top-down visit(f) {
    case q: question(_, _, i, e): cfs += [<i.ident, e>];
  }
  
  return "<for(c <- cfs) {>
  '  <individualCalculatedField(f.formName.ident, c)>
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
    default: return "Todo: <t>";
  }
}
