package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

import org.antlr.runtime.RecognitionException;

public class ANTLRParserExpressions extends ANTLRParser implements IParser {
	@Override
	public Expr parse(String src) throws ParseError {
		try {
			return getParser(src).orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}