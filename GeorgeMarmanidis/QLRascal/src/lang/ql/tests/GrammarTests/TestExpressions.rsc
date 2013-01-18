module lang::ql::tests::GrammarTests::TestExpressions

import lang::ql::syntax::QL;
import ParseTree;

public start[Expr] parseExpressions(str src) = parse(#start[Expr], src,|file:///-|);

public test bool testAdd1() = parseExpressions("a + b") is add;
public test bool testAdd2() = parseExpressions("a + b + c") is add;
public test bool testAdd3() = parseExpressions("(a + b + c)") is add;
public test bool testAdd4() = parseExpressions("a + (b + c)") is add;
public test bool testAdd5() = parseExpressions("(a + b) + c") is add;
public test bool testAdd6() = parseExpressions("(a + b)") is add;
public test bool testAdd7() = parseExpressions("a + b * c") is add;
public test bool testAdd8() = parseExpressions("a * b + c") is add;