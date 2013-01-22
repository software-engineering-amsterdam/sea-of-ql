package org.uva.sea.ql.interfaces;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.errors.ParseError;

public interface IParse {
	Statement parse(String src) throws ParseError;
}
