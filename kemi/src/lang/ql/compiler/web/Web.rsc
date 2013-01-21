module lang::ql::compiler::web::Web

import lang::ql::ast::AST;
import lang::ql::compiler::web::HTML;
import lang::ql::compiler::web::JS;
import lang::ql::compiler::web::PHP;
import lang::ql::compiler::web::SQL;

public loc buildForm(Form form, loc destFolder) {
  destFolder += "<form.formName>/";
  HTML(form, destFolder);
  JS(form, destFolder);
  PHP(form, destFolder);
  SQL(form, destFolder);
  return destFolder;
}
