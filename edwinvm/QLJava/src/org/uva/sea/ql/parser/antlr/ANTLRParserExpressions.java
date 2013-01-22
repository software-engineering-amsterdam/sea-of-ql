package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

public class ANTLRParserExpressions extends ANTLRParser implements IParser {
	@Override
	public Expr parse(String src) throws ParseError {
		return (Expr)parseInput(src, "orExpr");
	}
}