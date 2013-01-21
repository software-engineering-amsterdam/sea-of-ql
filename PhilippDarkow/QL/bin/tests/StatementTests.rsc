module tests::StatementTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;

private Statement p(str src) = implode(parse(src, |file:///test.q|));  // |file:///-|

// Tests for if statement
// public test bool testIf1() = p("if (a) { b }") is ifStat;
