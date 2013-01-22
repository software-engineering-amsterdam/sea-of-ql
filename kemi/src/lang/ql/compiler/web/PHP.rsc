module lang::ql::compiler::web::PHP

import IO;
import String;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;

private str title = ""; 

public void PHP(Form f, loc dest) {
  dest += "form.php";
  title = f.formName;
  writeFile(dest, createPHP(f));
}

private str createPHP(Form form) =
  "\<?php 
  '
  '  $__QARR = array();
  '
  '<for(e <- form.formElements) {>
  '  <createPHP(e)>
  '<}>
  '  <createQuery()>
  '?\>
  '";

private str createPHP(Statement item: question(Question question)) = 
  createPHP(question);

private str createPHP(Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    "<validator(answerDataType, answerIdentifier)>
    '<addToQueryArray(answerDataType, answerIdentifier)>
    ";

private str createPHP(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  
  cf = prependIdent(calculatedField, "$");
  
  return 
    "<addToQueryArray(answerDataType, answerIdentifier, prettyPrint(cf))>";
}

private str createPHP(Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) = 
    "if(<createPHP(ifPart.condition)>) { <for(e <- ifPart.body) {>
    '  <createPHP(e)><}><for(ei <- elseIfs) { >
    '} else if(<createPHP(ei.condition)>) { <for(e <- ei.body) {>
    '  <createPHP(e)><}><}><for(ep <- elsePart) { >
    '} else { <for(e <- ep.body) {>
    '  <createPHP(e)><}><}>
    '}";

private str createPHP(Expr e) =
  "<prettyPrint(prependIdent(e, "$"))>";

private str addToQueryArray(str answerDataType, str ident) =
  addToQueryArray(answerDataType, ident, "$_POST[\'<ident>\']");

private str addToQueryArray(str answerDataType, str ident, str expr) =
  "
  '$<ident> = <expr>;
  '$__QARR[] = [\"<ident>\", \"<preparedStatementShorthand(answerDataType)>\", $<ident>];
  '
  ";

private str createQuery() =
  //" TODO: QUERY MET $__QARR[];";
  /*
  '$stmt = $mysqli-\>prepare(\"INSERT INTO <title> (`<ident>`) VALUES (?)\");
  '$stmt-\>bind_param(\"<preparedStatementShorthand(answerDataType)>\", <val>);
  '$stmt-\>execute();";
  */
  "
  '$__QCOL = array();
  '$__QTYPE = array();
  '$__QVAL = array();
  '
  'foreach($__QARR as $value) {
  '  $__QCOL[] = $value[0];
  '  $__QTYPE[] = $value[1];
  '  $__QVAL[] = $value[2];
  '  $__QS[] = \"?\";
  '}
  '
  '$__query = \"INSERT INTO x_x (\" . implode(\",\",$__QCOL) . \") VALUES (\" . implode(\",\", $__QS) . \")\";
  '
  '$mysqli-\>prepare($__query);
  '
  'echo \"$stmt-\>bind_param(\'\" . implode(\"\", $__QTYPE) . \"\',\" . implode(\",\",$__QVAL) . \");\";
  '
  'echo \"\n\";
  ";
private str preparedStatementShorthand(str answerDataType) {      
  switch(answerDataType) {
    case "boolean": return "b";
    case "integer": return "i";
    case "money": return "m";
    case "date": return "d";
    case "string": return "s";
  };
}

private str validator(str answerDataType, str ident) {
  switch(answerDataType) {
    case "boolean": return validateBoolean(ident);
    case "integer": return validateInteger(ident);
    case "money": return validateMoney(ident);
    case "date": return validateDate(ident);
    case "string": return validateString(ident);
  }
}

private str validateBoolean(str ident) =
  "if(!(is_bool($_POST[\'<ident>\']))) {
  '  die(\"<ident> is not a boolean!\");
  '}";
  
private str validateInteger(str ident) =
  "if(!(is_int($_POST[\'<ident>\']))) {
  '  die(\"<ident> is not an integer!\");
  '}";

private str validateMoney(str ident) =
  "<ident> = floatval(<ident>);
  '_s<ident> = sprintf(\"%.2f\", <ident>);
  'ident = floatval($_s<ident>);";

private str validateDate(str ident) =
  "$<ident> = $_POST[\'<ident>\'];
  '$<ident>_arr = explode(\"-\", $<ident>);
  '
  '$__year = $<ident>_arr[0];
  '$__month = $<ident>_arr[1];
  '$__day = $<ident>_arr[2];
  '
  'if(!(checkDate($__month, $__day, $__year))) {
  '  die(\"<ident> is not a valid date!\");
  '}
  ";

private str validateString(str ident) =
  "if(!(is_string($_POST[\'<ident>\']))) {
  '  die(\"<ident> is not a string!\");
  '}";

private Expr prependIdent(Expr expr, str prepend) {
  return visit (expr) {
    case Expr e: ident(str name): insert ident(prepend + name);
  };
}
