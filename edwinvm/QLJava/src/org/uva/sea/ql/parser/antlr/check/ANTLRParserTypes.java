package org.uva.sea.ql.parser.antlr.check;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class ANTLRParserTypes extends ANTLRParser {
	@Override
	public Type parse(String src) throws ParseError {
		return (Type)parseInput(src, "type");
	}
}