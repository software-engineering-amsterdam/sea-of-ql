package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.statement.*;

public interface IParse {
	Expr parse(String src) throws ParseError;

	Question parseQuestion(String string) throws ParseError;

	IfStat parseIfElse(String string) throws ParseError;

	Form parseForm(String string) throws ParseError;
}