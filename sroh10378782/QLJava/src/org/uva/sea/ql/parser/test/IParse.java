package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.nodes.expressions.Expr;

public interface IParse {
	Expr parse(String src) throws ParseError;
}
