package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.ast.statements.AStatement;

public interface IParse {
	AExpr parseExpr(String src) throws ParseError;
	AStatement parseStatement(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
}