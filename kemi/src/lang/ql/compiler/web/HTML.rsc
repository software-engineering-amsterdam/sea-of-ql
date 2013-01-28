module lang::ql::compiler::web::HTML

import IO;
import String;
import lang::ql::ast::AST; 

public void HTML(Form f, loc dest) {
  dest += "index.html";
  
  str title = "";
  list[Question] questions = [];
  
  // Writing an empty string == truncating the file 
  writeFile(dest, "");
  
  top-down visit(f) {
    case form(def, _): title = def.ident;
    case q: question(_, _, _): questions += [q];
    case q: question(_, _, _, _): questions += [q];
  }
  
  createPage(title, questions, dest);
}

private void createPage(str title, list[Question] questions, loc dest) {
  html = 
  "\<!DOCTYPE html\>
  '\<html\>
  '  \<head\>
  '    \<meta charset=\"utf-8\"/\>
  '    \<title\><title>\</title\>
  '    \<script type=\"text/javascript\" src=\"checking.js\"\>\</script\>
  '    \<style type=\"text/css\" \>
  '      label { display: block; }
  '    \</style\>
  '  \</head\>
  '  \<body\>
  '    \<form id=\"<title>\" method=\"post\" action=\"MYURL\"\>
  '<for(q <- questions) {>
  '      <createQuestion(q)>
  '<}>
  '   \</form\>
  '  \</body\>
  '\</html\>
  ";
  appendToFile(dest, html);
}

private str createQuestion(Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    "\<div id=\"<answerIdentifier>Block\"\>
    '  \<label for=\"<answerIdentifier>\"\><substring(questionText.text, 1, size(questionText.text) - 1)>\</label\>
    '  \<input type=\"<answerDataType>\" id=\"<answerIdentifier>\" name=\"<answerIdentifier>\" /\>
    '\</div\>
    '";

private str createQuestion(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) =
    "\<div id=\"<answerIdentifier>Block\"\>
    '  \<label for=\"<answerIdentifier>\"\><substring(questionText.text, 1, size(questionText.text) - 1)>\</label\>
    '  \<input type=\"<answerDataType>\" id=\"<answerIdentifier>\" name=\"<answerIdentifier>\" disabled=\"disabled\"/\>
    '\</div\>
    '";
