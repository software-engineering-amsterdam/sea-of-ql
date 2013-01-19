package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Expression;

public interface IParse {
	Expression parse(String src) throws ParseError;
}
