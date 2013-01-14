module lang::ql::tests::expressions::String

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testString1() = parseExpr("\"afalse\"") is string;
public test bool testString2() = parseExpr("\"a b _c @ $ ^\"") is string;
public test bool testString3() = parseExpr("\"af\\\"alse\"") is string;

public test bool testRandomString() = parseExpr("\"<randomSentence()>\"") is string;
