package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;

public interface IParse {
	Expr parseExpr(String src) throws ParseError;
	FormElement parseFormElement(String src) throws ParseError;
}
