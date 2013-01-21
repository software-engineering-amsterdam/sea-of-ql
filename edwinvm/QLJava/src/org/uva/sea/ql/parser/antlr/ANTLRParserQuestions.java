package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.parser.ParseError;

import org.antlr.runtime.RecognitionException;

public class ANTLRParserQuestions extends ANTLRParser {
	@Override
	public FormStatement parse(String src) throws ParseError {
		try {
			return getParser(src).formStatement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}