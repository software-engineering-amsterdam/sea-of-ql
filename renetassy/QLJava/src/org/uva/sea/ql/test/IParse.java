package org.uva.sea.ql.test;


import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.errors.ParseError;

public interface IParse {
	Expr parse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError; 
}
