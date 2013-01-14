module lang::ql::tests::expressions::Addition

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import util::Random;

public test bool testAdd1() = parseExpr("a + b") is add;
public test bool testAdd2() = parseExpr("a + b + c") is add;
public test bool testAdd3() = parseExpr("(a + b + c)") is add;
public test bool testAdd4() = parseExpr("a + (b + c)") is add;
public test bool testAdd5() = parseExpr("(a + b) + c") is add;
public test bool testAdd6() = parseExpr("(a + b)") is add;
public test bool testAdd7() = parseExpr("a + b * c") is add;
public test bool testAdd8() = parseExpr("a * b + c") is add;
public test bool testAdd9() = parseExpr("a + b / c") is add;
public test bool testAdd10() = parseExpr("a / b + c") is add;

public test bool testRandomAdd() = parseExpr("<randomWord()> + <randomWord()>") is add;
