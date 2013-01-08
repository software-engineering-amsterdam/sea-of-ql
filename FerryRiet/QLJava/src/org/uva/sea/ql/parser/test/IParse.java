package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;

public interface IParse {
	Expr stmt(String src) throws ParseError;
	Expr parse(String src) throws ParseError;
}
