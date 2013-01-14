module lang::ql::tests::expressions::Ident

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testIdent1() = parseExpr("a") is ident;
public test bool testIdent2() = parseExpr("abc") is ident;
public test bool testIdent3() = parseExpr("ABC") is ident;
public test bool testIdent4() = parseExpr("ABCDEF") is ident;
public test bool testIdent5() = parseExpr("abc2323") is ident;
public test bool testIdent6() = parseExpr("a2bc232") is ident;
public test bool testIdent7() = parseExpr("a2bc232aa") is ident;
public test bool testIdent8() = parseExpr("a2bc232a") is ident;
public test bool testIdent9() = parseExpr("a2bc232aa") is ident;
public test bool testIdent10() = parseExpr("a2bc_232aa") is ident;
