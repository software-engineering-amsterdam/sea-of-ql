package org.uva.sea.ql.parser.antlr.check;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class ANTLRParserExpressions extends ANTLRParser implements IParser {
	@Override
	public Expr parse(String src) throws ParseError {
		return (Expr)parseInput(src, "orExpr");
	}
}