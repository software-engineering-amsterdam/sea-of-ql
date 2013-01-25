package parser.tests;

import ast.Expr;

public interface IParse {
	Expr parse(String src) throws ParseError;
}
