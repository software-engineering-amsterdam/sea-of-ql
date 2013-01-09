module lang::ql::tests::TestQuestions


import ParseTree;
import Exception;
import IO;
import util::ValueUI;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Question] parse(str src, loc l) = parse(#start[Question], src, l);

private Question implode(Tree t) = implode(#Question, t);
private Question load(loc l) = implode(parse(readFile(l), l));




private Question p(str src) = implode(parse(src, |file:///-|));

public test bool testAdd1() = p("form Hello") is question;

//public test bool testQuestion1() = p("\"HAllo?\", bool, var") is question;

public void main() {
    //try x = p("\"Hallo?\", boolean");
    //catch IllegalArgument( y, z ): text(y);
    //return;
    x = p("\"Hallo?\", boolean, nanana");
    println("sasadsadsadsadp: <x>  ss");
    println();
}
