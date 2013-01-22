package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.parser.ParseError;

public class ANTLRParserConditionBlocks extends ANTLRParser {
	@Override
	public FormStatement parse(String src) throws ParseError {
		return (FormStatement)parseInput(src, "conditionBlock");
	}
}