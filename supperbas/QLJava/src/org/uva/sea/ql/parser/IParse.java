package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Form;

public interface IParse {
	Form parse(String src) throws ParseError;
}
