package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.Statement;

public interface IParse {
	
	Form parseForm(String src) throws ParseError;
	
	Expression parseExpression(String src) throws ParseError;
	
	Statement parseStatement(String src) throws ParseError;
}
