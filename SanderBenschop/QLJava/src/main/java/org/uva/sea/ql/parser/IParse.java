package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.parser.exception.ParseError;

public interface IParse {
	
	QLExpression parse(String src) throws ParseError;
}
