module lang::ql::tests::expressions::String

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testString1() = parse("\"afalse\"") is string;
public test bool testString2() = parse("\"a b _c @ $ ^\"") is string;
public test bool testString3() = parse("\"af\\\"alse\"") is string;
