package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ANTLRStringStream;

public class ANTLRParser implements IParser {
	public QLParser getParser(String input)
	{
		ANTLRStringStream stream = new ANTLRStringStream(input);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}
	
	@Override
	public ASTNode parse(String src) throws ParseError {
		try {
			return getParser(src).formStatement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}