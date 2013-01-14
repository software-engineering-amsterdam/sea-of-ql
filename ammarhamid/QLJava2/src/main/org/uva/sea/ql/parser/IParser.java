package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.exception.ParserException;

public interface IParser
{
	void parseForm(String src) throws ParserException;
	
	Expr parseExpr(String src) throws ParserException;
}
