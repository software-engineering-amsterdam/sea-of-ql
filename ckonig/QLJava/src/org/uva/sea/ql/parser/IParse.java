package org.uva.sea.ql.parser;

import java.io.IOException;

import org.uva.sea.ql.ast.Expr;

public interface IParse {
	Expr parseForm(String src) throws ParseError;
	Expr parseFile(String src) throws ParseError, IOException;
	Expr parseExpression(String src) throws ParseError; 
}
