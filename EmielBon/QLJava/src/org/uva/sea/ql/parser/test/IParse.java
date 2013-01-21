package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.*;

public interface IParse {
	Node parse(String src) throws ParseError;
}
