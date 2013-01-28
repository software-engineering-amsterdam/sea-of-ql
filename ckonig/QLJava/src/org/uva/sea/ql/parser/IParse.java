package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Expr;

public interface IParse {
	Expr parseForm(String src) throws ParseError;
	Expr parseDefaultFile() throws ParseError;
	Expr parseExpression(String src) throws ParseError; 
}
