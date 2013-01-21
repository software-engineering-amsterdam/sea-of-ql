module tests::StatementTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;

private Statement p(str src) = implodeStatement(parse(src, |file:///testStatements.q|));  // |file:///-|

//Tests for if statement
public test bool testIf1() = p("if (a+b) { hasHouse : \"nmxyc \" string }") is ifStat;
//public test bool testIfElse() = p("") is ifElseStat;

