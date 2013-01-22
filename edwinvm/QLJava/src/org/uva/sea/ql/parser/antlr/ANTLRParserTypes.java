package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.parser.ParseError;

public class ANTLRParserTypes extends ANTLRParser {
	@Override
	public Type parse(String src) throws ParseError {
		return (Type)parseInput(src, "type");
	}
}