package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expression.Expr;

public interface IParse {
	Expr parse(String src) throws ParseError;
}
