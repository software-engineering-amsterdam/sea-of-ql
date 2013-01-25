@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::tests::ASTTests::TestConditionalStatement

import lang::ql::syntax::QL;
import ParseTree;
import IO;
import lang::ql::ast::AST;

private ConditionalStatement pCst(str src) = implodeCst(parseCst(src, |file:///-|));
private start[ConditionalStatement] parseCst(str src, loc l) = parse(#start[ConditionalStatement], src, l);
private ConditionalStatement implodeCst(Tree t) = implode(#ConditionalStatement, t);

public test bool testConStatement1()=pCst("if (a+b) {temp: \"has any dogs?\" boolean} else {temp: \"has any parents?\" boolean}") is ifCond;
public test bool testConStatement2()=pCst("if (a+b) {temp: \"has any dogs?\" boolean \n temp: \"how many dogs?\" integer} else {temp: \"has any parents?\" boolean \n temp: \"Where he lives?\" string}") is ifCond;

public test bool testConStatement3()=pCst("if (a+b) {temp: \"has any dogs?\" boolean \n temp: \"how many dogs?\" integer}") is simpleIfCond;

public test bool testConStatement4()=pCst("if (a+b) {temp: \"has any dogs?\" boolean \n temp: \"how many dogs?\" integer} else if (a-b) {temp: \"has any parents?\" boolean \n temp: \"Where he lives?\" string}  else  {temp: \"has any parents?\" boolean \n temp: \"Where he lives?\" string}") is ifElseIfCond;