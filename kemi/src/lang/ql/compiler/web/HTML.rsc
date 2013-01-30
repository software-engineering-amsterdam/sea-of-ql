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
  '    \<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js\"\>\</script\>
  '    \<script type=\"text/javascript\" src=\"http://jzaefferer.github.com/jquery-validation/jquery.validate.js\"\>\</script\>
  '    \<script\>
  '      $(document).ready(function(){
  '        validate<title>();
  '      });
  '    \</script\>
  '    \<style type=\"text/css\" \>
  '      label { display: block; }
  '      .error { float: none; color: red; padding-left: .5em; vertical-align: top; }
  '    \</style\>
  '  \</head\>
  '  \<body\>
  '    \<form id=\"<title>\" method=\"post\" action=\"form.php\"\>
  '<for(q <- questions) {>
  '      <createQuestion(q)>
  '<}>
  '      \<input type=\"submit\" value=\"Submit <title>\"\>
  '    \</form\>
  '  \</body\>
  '\</html\>
  ";
  appendToFile(dest, html);
}

private str createQuestion(Question q: 
  question(QuestionText text, Type \type, IdentDefinition ident)) =
    "\<div id=\"<ident.ident>Block\"\>
    '  \<label for=\"<ident.ident>\"\><substring(text.text, 1, size(text.text) - 1)>\</label\>
    '  \<input type=\"<\type.name>\" id=\"<ident.ident>\" class=\"required\" name=\"<ident.ident>\" /\>
    '\</div\>
    '";

private str createQuestion(Question q: 
  question(QuestionText text, Type \type, IdentDefinition ident, calculatedField)) =
    "\<div id=\"<ident.ident>Block\"\>
    '  \<label for=\"<ident.ident>\"\><substring(text.text, 1, size(text.text) - 1)>\</label\>
    '  \<input type=\"<\type.name>\" id=\"<ident.ident>\" class=\"required\" name=\"<ident.ident>\" disabled=\"disabled\"/\>
    '\</div\>
    '";
