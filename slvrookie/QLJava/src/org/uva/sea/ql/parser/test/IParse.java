package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.Type;

public interface IParse {

	Expr parseExpr(String src) throws ParseError;
	Type parseType(String src) throws ParseError;
	FormElement parseFormElement(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	
}
