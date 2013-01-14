module lang::ql::tests::expressions::And

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testAnd1() = parseExpr("a && b") is and;
public test bool testAnd2() = parseExpr("a && b && c") is and;
public test bool testAnd3() = parseExpr("(a && b && c)") is and;
public test bool testAnd4() = parseExpr("a && (b || c)") is and;
public test bool testAnd5() = parseExpr("(a || b) && c") is and;
public test bool testAnd6() = parseExpr("(a && b)") is and;

public test bool testRandomAnd() = parseExpr("<randomWord()> && <randomWord()>") is and;
