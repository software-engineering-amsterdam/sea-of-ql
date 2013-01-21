package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import java.util.List;

public interface IParse {
	Expression parseExpr(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	FormElement parseFormElement(String src) throws ParseError;
	List<FormElement> parseFormElements(String src) throws ParseError;
}
