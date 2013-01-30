module lang::ql::compiler::web::JS

import IO;
import String;
import lang::ql::ast::AST; 
import lang::ql::compiler::PrettyPrinter;

public void JS(Form f, loc dest) {
  dest += "checking.js";
  
  writeFile(dest, "");
  appendToFile(dest, JS(f));
}

private str JS(Form f) =
  "function validate<f.formName.ident>() {
  '  $(\"#<f.formName.ident>\").validate({
  '    rules: {
  '      <createValidationRules(f)>
  '    }
  '  });
  '
  '  <calculatedFields(f)>
  '}
  ";
  
private str calculatedFields(Form f) {
  list[tuple[str ident, Expr expr]] cfs = [];
  
  top-down visit(f) {
    case q: question(_, _, i, e): cfs += [<i.ident, e>];
  }
  
  return "<for(c <- cfs) {>
  '  <individualCalculatedField(c)>
  '<}>";
}
  
private str individualCalculatedField(tuple[str ident, Expr expr] cf) {  
  list[str] eidents = [];
  
  top-down visit(cf.expr) {
    case Expr e: ident(str name): eidents += name;
  }

  return "
  '$(\"#calculatedField\").change(function(e)  {
  '  var result;
  '  <for(e <- eidents) {>
  '    var <e> = $(\"#<e>\").val();
  '    console.log(<e>);
  '  <}>
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
    default: return "Todo: <t>";
  }
}

public str prettyPrint(Statement item: question(Question question)) = 
  prettyPrint(question);

public str prettyPrint(Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    "<questionText.text>
    '  <answerDataType.name> <answerIdentifier.ident>";

public str prettyPrint(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) =
    "<questionText.text>
    '  <answerDataType.name> <answerIdentifier.ident> = <prettyPrint(calculatedField)>";
  