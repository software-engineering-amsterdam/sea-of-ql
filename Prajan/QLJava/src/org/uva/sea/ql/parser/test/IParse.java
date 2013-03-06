package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.form.Form;

public interface IParse {
	Expr parse(String src) throws ParseError;
}
