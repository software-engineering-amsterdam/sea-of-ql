package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;

public interface IParse {
	Form parseForm(String src) throws ParseError;
	Form parseDefaultFile() throws ParseError;
	Expr parseExpression(String src) throws ParseError; 
}
