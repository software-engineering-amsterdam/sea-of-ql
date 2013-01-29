package org.uva.sea.ql.test;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expressions.Expr;

public interface IParse {
	Form parseForm(String src) throws ParseError;
	Expr parseExpr(String src) throws ParseError;
}
