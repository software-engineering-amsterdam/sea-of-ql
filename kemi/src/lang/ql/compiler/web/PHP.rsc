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
  '<for(e <- form.formElements) {>
  '  <createPHP(e)>
  '<}>
  '?\>
  '";

private str createPHP(Statement item: question(Question question)) = 
  createPHP(question);

private str createPHP(Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    "<validator(answerDataType, answerIdentifier)>
    '<createQuery(answerDataType, answerIdentifier)>
    ";

private str createPHP(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  
  // TODO: Rewrite idents in calculatedField
  cf = calculatedField;
  
  return 
    "<validator(answerDataType, answerIdentifier)>
    '<createQuery(answerDataType, answerIdentifier, prettyPrint(cf))>
    ";
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
  "<e>";

  
private str validator(answerDataType, ident) {
  switch(answerDataType) {
    case "boolean": return validateBoolean(ident);
    case "integer": return validateInteger(ident);
    case "money": return validateMoney(ident);
    case "date": return validateDate(ident);
    case "string": return validateString(ident);
  }
}

private str validateBoolean(ident) =
  "die(B<ident>);";
  
private str validateInteger(ident) =
  "die(I<ident>);";
  
private str validateMoney(ident) =
  "die(M<ident>);";

private str validateDate(ident) =
  "die(D<ident>);";

private str validateString(ident) =
  "die(S<ident>);";
  
private str createQuery(answerDataType, ident) =
  "$<ident> = $_POST[\'<ident>\'];
  '<preparedStatement(answerDataType, "$<ident>")>";
  
private str createQuery(answerDataType, ident, expr) =
  "$<ident> = <expr>;
  '<preparedStatement(answerDataType, "$<ident>")>";  
  
private str preparedStatement(answerDataType, val) {
  ret = "$stmt = $mysqli-\>prepare(\"INSERT INTO <title> (`ident`) VALUES (?)\");\n";
  switch(answerDataType) {
    case "boolean": ret += preparedStatementBoolean(val);
    case "integer": ret += preparedStatementInteger(val);
    case "money": ret += preparedStatementMoney(val);
    case "date": ret += preparedStatementDate(val);
    case "string": ret += preparedStatementString(val);
  }
  return ret + "\n$stmt-\>execute();";
}
private str preparedStatementBoolean(val) = 
  "$stmt-\>bind_param(\"b\", <val>);";
  
private str preparedStatementInteger(val) = 
  "$stmt-\>bind_param(\"i\", <val>);";

private str preparedStatementMoney(val) = 
  "$stmt-\>bind_param(\"m\", <val>);";

private str preparedStatementDate(val) = 
  "$stmt-\>bind_param(\"d\", <val>);";

private str preparedStatementString(val) = 
  "$stmt-\>bind_param(\"s\", <val>);";
