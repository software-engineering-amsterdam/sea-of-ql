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
  
  cf = prependIdent(calculatedField, "$");
  
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
  "<prettyPrint(prependIdent(e, "$"))>";
  
private str createQuery(str answerDataType, str ident) =
  "$<ident> = $_POST[\'<ident>\'];
  '<preparedStatement(answerDataType, "$<ident>")>";
  
private str createQuery(str answerDataType, str ident, str expr) =
  "$<ident> = <expr>;
  '<preparedStatement(answerDataType, "$<ident>")>";  
  
private str preparedStatement(str answerDataType, str val) =
  "$stmt = $mysqli-\>prepare(\"INSERT INTO <title> (`ident`) VALUES (?)\");
  '$stmt-\>bind_param(\"<preparedStatementShorthand(answerDataType)>\", <val>);
  '$stmt-\>execute();";
  
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
  "if(!(is_bool(<ident>)) die(\"<ident> is not a boolean!\");";
  
private str validateInteger(str ident) =
  "if(!(is_int(<ident>)) die(\"<ident> is not an integer!\");";

private str validateMoney(str ident) =
  "die(M<ident>);";

private str validateDate(str ident) =
  "die(D<ident>);";

private str validateString(str ident) =
  "if(!(is_string(<ident>)) die(\"<ident> is not a string!\");";

private Expr prependIdent(Expr expr, str prepend) {
  return visit (expr) {
    case Expr e: ident(str name): insert ident(prepend + name);
  };
}
