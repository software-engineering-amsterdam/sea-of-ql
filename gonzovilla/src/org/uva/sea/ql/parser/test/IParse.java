package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.QLParser;

public interface IParse {
	QLParser parse(String src) throws ParseError;
	Expr parseExpr(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	Type parseType(String src) throws ParseError;
}
