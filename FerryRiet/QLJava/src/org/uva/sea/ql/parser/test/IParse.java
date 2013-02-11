package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.operators.Expr;

public interface IParse {
	QLProgram qlprogram(String src)  throws ParseError;
	Statement statement(String src)  throws ParseError;
	Expr expr(String src) throws ParseError;
}
