module lang::ql::tests::expressions::Ident

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testIdent1() = parse("a") is ident;
public test bool testIdent2() = parse("abc") is ident;
public test bool testIdent3() = parse("ABC") is ident;
public test bool testIdent4() = parse("ABCDEF") is ident;
public test bool testIdent5() = parse("abc2323") is ident;
public test bool testIdent6() = parse("a2bc232") is ident;
public test bool testIdent7() = parse("a2bc232aa") is ident;
public test bool testIdent8() = parse("a2bc232a") is ident;
public test bool testIdent9() = parse("a2bc232aa") is ident;
public test bool testIdent10() = parse("a2bc_232aa") is ident;
