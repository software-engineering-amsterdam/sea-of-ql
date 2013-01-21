package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.parser.ParseError;

import org.antlr.runtime.RecognitionException;

public class ANTLRParserTypes extends ANTLRParser {
	@Override
	public Type parse(String src) throws ParseError {
		try {
			return getParser(src).type();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}