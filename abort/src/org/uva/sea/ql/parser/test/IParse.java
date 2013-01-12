package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expression;

public interface IParse {
	Expression parse(String src) throws ParseError;
}
