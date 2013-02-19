package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.parser.rats.ParseError;

public interface IParse {
	Statement parse(String src) throws ParseError;
}
