package nl.stgm.ql.parser;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.ast.form.Form;
import nl.stgm.ql.ast.Expr;

public interface IParse
{
	Document parse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	Expr parseExpr(String src) throws ParseError;
}
