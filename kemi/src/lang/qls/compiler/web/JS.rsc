module lang::qls::compiler::web::JS

import IO;
import lang::ql::ast::AST;
import lang::qls::ast::AST;

public void JS(Form form, Stylesheet sheet, loc dest) {
  dest += "styling.js";
  
  writeFile(dest, JS(form, sheet));
}

private str JS(Form form, Stylesheet sheet) { 
  return "function styling() { console.log(\"<form.formName.ident> with <sheet.ident>\"); }";
}