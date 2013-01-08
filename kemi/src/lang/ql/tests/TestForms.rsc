module lang::ql::tests::TestForms

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import lang::ql::util::Implode;

import Exception;
import IO;
import util::ValueUI;


private Form p(str src) = implode(parse(src, |file:///-|));

public test bool testAdd1() = p("form Hello") is form;

//public test bool testQuestion1() = p("\"HAllo?\", bool, var") is question;

public void main() {
    //try x = p("form hallo");
    //catch IllegalArgument( y, z ): text(y);
    
    x = p("form SSSSS { \"Hallo?\", boolean, halloQuest \"Hallo?\", boolean, halloQuest }");
    text(x);
    println("sasadsadsadsadp: <x>  ss");
    println();
}
