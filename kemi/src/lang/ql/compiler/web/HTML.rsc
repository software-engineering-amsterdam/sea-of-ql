@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::HTML

import Configuration;
import IO;
import lang::ql::\ast::AST; 
import util::StringHelper;

public void HTML(Form f, loc dest) {
  dest += getHTMLName();
  
  str title = "";
  list[Question] questions = [];
  
  writeFile(dest, "");
  
  top-down visit(f) {
    case form(def, _): title = def.ident;
    case q: question(_, _, _): questions += [q];
    case q: question(_, _, _, _): questions += [q];
  }
  
  writeFile(dest, createPage(title, questions));
  
}

private str createPage(str title, list[Question] questions) =
  "\<!DOCTYPE html\>
  '\<html\>
  '  \<head\>
  '    \<!-- THIS IS AN AUTOMATICALLY GENERATED FILE. DO NOT EDIT! --\>
  '    \<meta charset=\"utf-8\"/\>
  '    \<title\><title>\</title\>
  '    \<script type=\"text/javascript\" src=\"jquery.min.js\"\>\</script\>
  '    \<script type=\"text/javascript\" src=\"jquery.validate.js\"\>\</script\>
  '    \<script type=\"text/javascript\" src=\"static.js\"\>\</script\>
  '    \<script type=\"text/javascript\" src=\"checking.js\"\>\</script\>
  '    \<script type=\"text/javascript\" src=\"styling.js\"\>\</script\>
  '    \<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" /\>
  '    \<script\>
  '      $(document).ready(function(){
  '        validate<title>();
  '      });
  '    \</script\>
  '  \</head\>
  '  \<body\>
  '    \<form id=\"<title>\" method=\"post\" action=\"form.php\"\>
  '<for(q <- questions) {>
  '      <createQuestion(title, q)>
  '<}>
  '      \<input id=\"submit\" type=\"submit\" value=\"Submit <title>\"\>
  '    \</form\>
  '  \</body\>
  '\</html\>
  ";

private str createQuestion(str title, Question q: 
    question(QuestionText text, Type \type, IdentDefinition ident)) =
  "\<div id=\"<ident.ident>Block\"\>
  '  \<label for=\"<ident.ident>\"\><trimQuotes(text.text)>\</label\>
  '  \<select id=\"<ident.ident>\" name=\"<ident.ident>\" form=\"<title>\"\>
  '  \<option value=\"\"\>Choose an answer\</option\>
  '  \<option value=\"true\"\>Yes\</option\>
  '  \<option value=\"false\"\>No\</option\>
  '  \</select\>
  '\</div\>
  '" 
    when \type.name == "boolean";

private default str createQuestion(str title, Question q: 
    question(QuestionText text, Type \type, IdentDefinition ident)) =
  "\<div id=\"<ident.ident>Block\"\>
  '  \<label for=\"<ident.ident>\"\><trimQuotes(text.text)>\</label\>
  '  \<input type=\"<\type.name>\" id=\"<ident.ident>\" name=\"<ident.ident>\" /\>
  '\</div\>
  '";

private str createQuestion(str title, Question q: 
    question(QuestionText text, Type \type, IdentDefinition ident, 
    calculatedField)) =
  "\<div id=\"<ident.ident>Block\"\>
  '  \<label for=\"<ident.ident>\"\><trimQuotes(text.text)>\</label\>
  '  \<input type=\"<\type.name>\" id=\"<ident.ident>\" name=\"<ident.ident>\" disabled=\"disabled\"/\>
  '\</div\>
  '";
