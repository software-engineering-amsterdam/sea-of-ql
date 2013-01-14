module lang::ql::tests::expressions::Multiplication

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import util::Random;

public test bool testMul1() = parseExpr("a * b") is mul;
public test bool testMul2() = parseExpr("a * b * c") is mul;
public test bool testMul3() = parseExpr("a * (b * c)") is mul;
public test bool testMul4() = parseExpr("(a * b) * c") is mul;
public test bool testMul5() = parseExpr("(a * b)") is mul;
public test bool testMul6() = parseExpr("(a + b) * c") is mul;
public test bool testMul7() = parseExpr("a * (b + c)") is mul;

public test bool testRandomMul() = parseExpr("<randomWord()> * <randomWord()>") is mul;
