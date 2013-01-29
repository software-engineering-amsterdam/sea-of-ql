@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::tests::ASTTests::TestElseIf

import lang::ql::syntax::QL;
import ParseTree;
import IO;
import lang::ql::ast::AST;

private ElseIf pEls(str src) = implodeEls(parseEls(src, |file:///-|));
private start[ElseIf] parseEls(str src, loc l) = parse(#start[ElseIf], src, l);
private ElseIf implodeEls(Tree t) = implode(#ElseIf, t);

public test bool testElseIf1()=pEls("else if (a+b) {temp: \"has any dogs?\" boolean}") is elseif;
public test bool testElseIf2()=pEls("else if (a+b) {temp: \"has any dogs?\" \n
 boolean temp: \"how many dogs?\" integer \n
 temp: \"What ages?\" string}") is elseif;