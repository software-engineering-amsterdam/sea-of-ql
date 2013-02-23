package org.uva.sea.ql.parser.antlr.check;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class ANTLRParserExpressions extends ANTLRParser implements IParser {
	@Override
	public Expression parse(String src) throws ParseError {
		return (Expression)parseInput(src, "orExpression");
	}
}