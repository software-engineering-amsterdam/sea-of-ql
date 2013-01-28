package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;

public interface IParse {
	Expr parseExpression(String src) throws ParseError;

	Type parseType(String src) throws ParseError;
}
