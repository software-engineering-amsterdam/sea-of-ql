package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.parser.antlr.QLParser;

public interface IParse {
	QLParser parse(String src) throws ParseError;
}
