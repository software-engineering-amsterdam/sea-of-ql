package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Form;

public interface Parser {
	Form parse(String src) throws ParseError;
}
