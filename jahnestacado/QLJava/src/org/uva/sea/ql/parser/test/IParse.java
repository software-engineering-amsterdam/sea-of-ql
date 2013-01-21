package org.uva.sea.ql.parser.test;

import java.util.List;


import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfBlock;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.QLParser;



public interface IParse {

	Expr parseExpr(String src) throws ParseError;
    Form parseForm(String src) throws ParseError;
	Type parseType(String src) throws ParseError;
	Question parseQuestion(String src) throws ParseError;
	ComputedQuestion parseComputedQuestion(String src) throws ParseError;
	IfBlock parseIfBlock(String src) throws ParseError;
	List<Element> parseBody(String src) throws ParseError;
}
