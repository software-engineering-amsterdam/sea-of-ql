module lang::ql::compiler::web::PHP

import IO;
import String;
import lang::ql::ast::AST; 

public void PHP(Form f, loc dest) {
  dest += "form.php";
  
  str title = "";
  list[Question] questions = [];
  
  // Writing an empty string == truncating the file 
  writeFile(dest, "\<?php \necho \"This is PHP!\"\n?\>");
}
