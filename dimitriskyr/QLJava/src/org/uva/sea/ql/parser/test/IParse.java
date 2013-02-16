package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;

public interface IParse {
	Expr parseExpression(String src) throws ParseError;
	Type parseType(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	Statement parseSimpleQuestion(String src) throws ParseError ; 
	Statement parseIfThen(String src) throws ParseError;
	Statement parseIfThenElse(String src) throws ParseError;
}
