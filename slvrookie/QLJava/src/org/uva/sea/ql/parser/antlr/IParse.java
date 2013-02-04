package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.ast.formelements.FormElement;
import org.uva.sea.ql.ast.types.Type;

public interface IParse {

	Expr parseExpr(String src) throws ParseError;
	Type parseType(String src) throws ParseError;
	FormElement parseFormElement(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	
}
