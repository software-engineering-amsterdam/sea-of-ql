package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.form.Form;

public interface IParse {
	Expr parse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
}
