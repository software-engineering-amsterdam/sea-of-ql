package org.uva.sea.ql.parser.antlr.check;

import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.errors.ParseError;

public class ANTLRParserQuestions extends ANTLRParser {
	@Override
	public FormStatement parse(String src) throws ParseError {
		return (FormStatement)parseInput(src, "formStatement");
	}
}