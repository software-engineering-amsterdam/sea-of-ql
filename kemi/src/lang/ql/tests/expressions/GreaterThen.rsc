module lang::ql::tests::expressions::GreaterThen

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testGt1() = parseExpr("a \> b") is gt;
public test bool testGt2() = parseExpr("a + b \> c") is gt;
public test bool testGt3() = parseExpr("a \> b + c") is gt;

public test bool testRandomGt() = parseExpr("<randomWord()> \> <randomWord()>") is gt;
