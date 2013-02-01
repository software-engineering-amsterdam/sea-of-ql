package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.ConditionalElement;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;




public interface IParse {

	Expr parseExpr(String src) throws ParseError;
    Form parseForm(String src) throws ParseError;
	Type parseType(String src) throws ParseError;
	Question parseQuestion(String src) throws ParseError;
	ComputedQuestion parseComputedQuestion(String src) throws ParseError;
	Body parseBody(String src) throws ParseError;
	ConditionalElement parseConditionalElement(String src) throws ParseError;
}
