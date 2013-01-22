module lang::ql::compiler::web::blah

import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import lang::ql::compiler::web::Web;

import IO;
import util::ValueUI;

// DELETE When done

private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

public void main() {
  //f = p(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|);
  //f = p(|project://QL-R-kemi/forms/calculatedField.q|);
  f = p(|project://QL-R-kemi/forms/ifCondition.q|);
  buildForm(f, |tmp:///web/|);
}
