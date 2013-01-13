package nl.stgm.ql.parser.test;

import nl.stgm.ql.ast.Expr;

public interface IParse {
	Expr parse(String src) throws ParseError;
}
