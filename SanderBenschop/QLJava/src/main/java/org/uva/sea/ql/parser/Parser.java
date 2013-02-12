package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.exception.ParseException;

public interface Parser {
	
	Form parse(String src) throws ParseException;
}
