module lang::ql::tests::expressions::Subtraction

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testsub1() = parse("a - b") is sub;
public test bool testSub2() = parse("a - b - c") is sub;
public test bool testSub3() = parse("(a - b - c)") is sub;
public test bool testSub4() = parse("a - (b - c)") is sub;
public test bool testSub5() = parse("(a - b) - c") is sub;
public test bool testSub6() = parse("(a - b)") is sub;
public test bool testSub7() = parse("a - b * c") is sub;
public test bool testSub8() = parse("a * b - c") is sub;
public test bool testSub9() = parse("a - b / c") is sub;
public test bool testSub10() = parse("a / b - c") is sub;
