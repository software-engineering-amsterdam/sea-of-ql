package org.uva.sea.ql.parser.rats;

import org.uva.sea.ql.ast.Statement;

public interface IParse {
	Statement parse(String src) throws ParseError;
}
