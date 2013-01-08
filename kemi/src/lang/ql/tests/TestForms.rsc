module lang::ql::tests::TestForms

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import lang::ql::util::Implode;

import Exception;
import IO;
import util::ValueUI;


private Form p(str src) = implode(parse(src, |file:///-|));
private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

public test bool testAdd1() = p("form Hello") is form;

//public test bool testQuestion1() = p("\"HAllo?\", bool, var") is question;

public void main() {
    //try x = p(|project://QL-R/src/lang/ql/tests/form.q|);
    //catch IllegalArgument( y, z ): text([z, y]);
    //return;
    
    //text(readFile(|project://QL-R/src/lang/ql/tests/form.q|));
    
    //x = p("form SSSSS { \"What is your number?\", integer, numberQuestion \"3x your number is\", integer, numberx3: numberQuestion * 3 }");
    
    x = p(|project://QL-R/src/lang/ql/tests/form.q|);
    
    text(x);
    println("sasadsadsadsadp: <x>  ss");
    println();
}
