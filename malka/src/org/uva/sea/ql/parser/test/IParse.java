package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IFormElement;
import java.util.List;

public interface IParse {
	Expression parseExpr(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	IFormElement parseFormElement(String src) throws ParseError;
	List<IFormElement> parseFormElements(String src) throws ParseError;
}
