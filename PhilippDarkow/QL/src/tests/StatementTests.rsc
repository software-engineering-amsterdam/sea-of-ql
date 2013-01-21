module tests::StatementTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;

private Statement p(str src) = implodeStatement(parseStatement(src, |file:///testStatements.q|));  // |file:///-|

//Tests for if statement
public test bool testIf1() = p("if (a) { hasHouse : \"Cool nice \" string }") is ifStat;
public test bool testIf2() = p("if (a+b) { hasSoldHouse : \"Cool nice \" boolean }") is ifStat;
public test bool testIfElse1() =p("if (a) { hasSoldHouse : \"Cool nice \" boolean } else { hasBought : \"bought house\" money }") is ifElseStat;

//public test bool testAsg1() = p("ad : boolean");
