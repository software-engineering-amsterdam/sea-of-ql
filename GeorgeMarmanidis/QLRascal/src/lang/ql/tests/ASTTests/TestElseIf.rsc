module lang::ql::tests::ASTTests::TestElseIf

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private ElseIf p(str src) = implode(parse(src, |file:///-|));

public test bool testElseIf1()=p("else if (a+b) {temp: \"has any dogs?\" boolean}") is elseif;
public test bool testElseIf2()=p("else if (a+b) {temp: \"has any dogs?\" \n
 boolean temp: \"how many dogs?\" integer \n
 temp: \"What ages?\" string}") is elseif;