package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.*;

public interface IParse {
	QLProgram qlprogram(String src)  throws ParseError;
	Expr parse(String src) throws ParseError;
}
