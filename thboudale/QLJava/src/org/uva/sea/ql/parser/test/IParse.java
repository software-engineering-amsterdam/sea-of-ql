package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.statements.Statement;

public interface IParse {
	Expr parseExpr(String src) throws ParseError;
	Statement parseStatement(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
}
