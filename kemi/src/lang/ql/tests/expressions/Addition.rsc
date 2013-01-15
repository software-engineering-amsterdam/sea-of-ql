module lang::ql::tests::expressions::Addition

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testAdd1() = parse("a + b") is add;
public test bool testAdd2() = parse("a + b + c") is add;
public test bool testAdd3() = parse("(a + b + c)") is add;
public test bool testAdd4() = parse("a + (b + c)") is add;
public test bool testAdd5() = parse("(a + b) + c") is add;
public test bool testAdd6() = parse("(a + b)") is add;
public test bool testAdd7() = parse("a + b * c") is add;
public test bool testAdd8() = parse("a * b + c") is add;
public test bool testAdd9() = parse("a + b / c") is add;
public test bool testAdd10() = parse("a / b + c") is add;
