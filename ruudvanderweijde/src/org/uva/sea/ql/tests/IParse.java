package org.uva.sea.ql.tests;

import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.error.ParseError;

public interface IParse {
	Expr parseExpression(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	Statement parseStatement(String src) throws ParseError;
	
	boolean hasErrors();
	List<Message> getErrors();
}