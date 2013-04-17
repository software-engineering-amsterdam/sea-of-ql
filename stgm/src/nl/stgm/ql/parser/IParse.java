package nl.stgm.ql.parser;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.ast.form.Form;

public interface IParse
{
	Document parse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
	ASTExpressionNode parseExpr(String src) throws ParseError;
}
