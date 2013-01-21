package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.statements.Question;

public interface IParse {
	Expr parseExpr(String src) throws ParseError;
	Question parseForm(String src) throws ParseError;
}
