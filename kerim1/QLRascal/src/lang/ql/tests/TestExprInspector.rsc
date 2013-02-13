module lang::ql::tests::TestExprInspector

import ParseTree;
import lang::ql::util::Parse;

import lang::ql::ast::AST;
import lang::ql::ast::ExprInspector;

private Expr p(str src) = implode(#Expr, parseExpr(src));

public test bool testIdentifiersInExpr1() = 
	{"abc"} := getAllIndentifiersInExpr(p("abc"));
	
public test bool testIdentifiersInExpr2() = 
	{"a", "b", "c"} := getAllIndentifiersInExpr(p("a \< b + c"));
	
public test bool testIdentifiersInExpr3() = 
	{"ab"} := getAllIndentifiersInExpr(p("ab == \"c\""));