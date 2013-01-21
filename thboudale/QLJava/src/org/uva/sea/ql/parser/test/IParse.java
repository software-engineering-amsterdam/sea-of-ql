package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.ifElseStatement;
import org.uva.sea.ql.ast.statements.ifStatement;

public interface IParse {
	Expr parseExpr(String src) throws ParseError;
	Question parseQuestion(String src) throws ParseError;
	ComputedQuestion parseCQ(String src) throws ParseError;
	ifStatement parseIf(String src) throws ParseError;
	ifElseStatement parseIfElse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
}
