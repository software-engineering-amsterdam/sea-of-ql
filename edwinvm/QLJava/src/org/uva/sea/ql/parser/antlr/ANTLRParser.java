package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.uva.sea.ql.parser.IParser;

public abstract class ANTLRParser implements IParser {
	public QLParser getParser(String input)
	{
		ANTLRStringStream stream = new ANTLRStringStream(input);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}
}