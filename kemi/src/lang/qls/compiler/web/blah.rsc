module lang::qls::compiler::web::blah

import lang::ql::ast::AST;
import lang::ql::compiler::web::Web;
import lang::ql::tests::ParseHelper;
import lang::qls::ast::AST;
import lang::qls::compiler::web::Web;
import lang::qls::tests::ParseHelper;

import IO;
import util::ValueUI;

private loc DEST = |project://QL-R-kemi/output/test/|;

public void main() {
  str l = "taxOfficeExample";
  
  fl = |project://QL-R-kemi/forms/| + (l + ".q");
  sl = |project://QL-R-kemi/stylesheets/| + (l + ".qs");
  
  dest = |project://QL-R-kemi/output/test/|;
  
  Form f = parseForm(fl);

  Stylesheet s = parseStylesheet(sl);  

  buildForm(f, DEST);
  
  buildSheet(f, s, DEST);
}