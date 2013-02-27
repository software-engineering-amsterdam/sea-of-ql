@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::PHP

import Configuration;
import IO;
import String;
import lang::ql::\ast::AST;
import lang::ql::compiler::web::PHPExpressionPrinter;

private str title = "";

public void php(Form f, loc dest) {
  dest += getPHPName();
  title = f.formName.ident;
  writeFile(dest, createPHP(f));
}

private str createPHP(Form form) =
  "\<?php
  ' 
  '  //THIS IS AN AUTOMATICALLY GENERATED FILE. DO NOT EDIT!
  '
  '  $__RES = array();
  '
  '<for(e <- form.formElements) {>
  '  <createPHP(e)>
  '<}>
  '  <createJSON()>
  '?\>
  '";

private str createPHP(Statement item: question(Question question)) = 
  createPHP(question);

private str createPHP(Question q: 
  question(_, answerDataType, answerIdentifier)) =
    "<validator(answerDataType, answerIdentifier.ident)>
    '<addToArray(answerDataType, answerIdentifier.ident)>
    ";

private str createPHP(Question q: 
  question(_, answerDataType, ansIdent, calculatedField)) =
    "<addToArray(answerDataType, ansIdent.ident, phpPrint(prependIdent(calculatedField, "$")))>";

private str createPHP(Statement item: 
    ifCondition(Conditional ifPart, list[Conditional] elseIfs, 
    list[ElsePart] elsePart)) = 
  "if(<createPHP(ifPart.condition)>) { <for(e <- ifPart.body) {>
  '  <createPHP(e)><}><for(ei <- elseIfs) { >
  '} else if(<createPHP(ei.condition)>) { <for(e <- ei.body) {>
  '  <createPHP(e)><}><}><for(ep <- elsePart) { >
  '} else { <for(e <- ep.body) {>
  '  <createPHP(e)><}><}>
  '}";

private str createPHP(Expr e) =
  "<phpPrint(prependIdent(e, "$"))>";

private str addToArray(Type answerDataType, str ident) =
  addToArray(answerDataType, ident, "$_POST[\'<ident>\']");
  
private str addToArray(Type answerDataType: booleanType(_), 
  str ident, str expr) =
    "
    '$<ident> = <expr> === \"true\";
    '$__RES[\"<ident>\"] = $<ident>;
    '
    ";
    
private str addToArray(Type answerDataType, str ident, str expr) =
  "
  '$<ident> = <expr>;
  '$__RES[\"<ident>\"] = $<ident>;
  '
  ";

private str createJSON() =
  "
  '$__JSON = json_encode($__RES);
  '
  'print_r($__JSON);
  'echo \"\n\";
  ";
  
private str validator(Type \type: booleanType(_), str ident) =
  validateBoolean(ident);
  
private str validator(Type \type: integerType(_), str ident) =
  validateInteger(ident);
  
private str validator(Type \type: moneyType(_), str ident) =
  validateMoney(ident);
  
private str validator(Type \type: dateType(_), str ident) =
  validateDate(ident);

private str validator(Type \type: stringType(_), str ident) =
  validateString(ident);    

private str validateBoolean(str ident) =
  "if(!isset($_POST[\'<ident>\'])) {
  '  // A boolean which is not set means false.
  '  $_POST[\'<ident>\'] = \"false\";
  '} else if($_POST[\'<ident>\'] === \"true\" || 
  '          $_POST[\'<ident>\'] === \"false\") {
  '} else {
  '  die(\"<ident> is not a boolean!\");
  '}";
  
private str validateInteger(str ident) =
  "if(!(is_int((integer) $_POST[\'<ident>\']))) {
  '  die(\"<ident> is not an integer!\");
  '}";

private str validateMoney(str ident) =
  "$<ident> = floatval($_POST[\'<ident>\']);
  '$_s<ident> = sprintf(\"%.2f\", $<ident>);
  '$<ident> = floatval($_s<ident>);";

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
