package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Value;

public interface IParse {
	Expr parseExpression(String src) throws ParseError;

	Value parseValue(String src) throws ParseError;
}
