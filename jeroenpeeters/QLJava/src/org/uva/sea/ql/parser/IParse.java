package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Expression;

public interface IParse {
	
	Form parseForm(String src) throws ParseError;
	
	Expression parseExpression(String src) throws ParseError;
	
	Statement parseStatement(String src) throws ParseError;
}
