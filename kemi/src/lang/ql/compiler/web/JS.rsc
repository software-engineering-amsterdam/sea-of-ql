module lang::ql::compiler::web::JS

import IO;
import String;
import lang::ql::ast::AST; 

public void JS(Form f, loc dest) {
  dest += "checking.js";
  
  writeFile(dest, "");  
}
