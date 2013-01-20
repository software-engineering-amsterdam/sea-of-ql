module lang::ql::tests::ASTTests::TestElseIf

import lang::ql::syntax::QL;
import ParseTree;
import IO;
import lang::ql::ast::AST;

private ElseIf p(str src) = implode(parse(src, |file:///-|));
private start[ElseIf] parse(str src, loc l) = parse(#start[ElseIf], src, l);
public ElseIf implode(Tree t) = implode(#ElseIf, t);

public test bool testElseIf1()=p("else if (a+b) {temp: \"has any dogs?\" boolean}") is elseif;
public test bool testElseIf2()=p("else if (a+b) {temp: \"has any dogs?\" \n
 boolean temp: \"how many dogs?\" integer \n
 temp: \"What ages?\" string}") is elseif;