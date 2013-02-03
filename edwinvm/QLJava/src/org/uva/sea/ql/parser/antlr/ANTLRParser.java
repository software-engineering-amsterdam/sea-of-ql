package org.uva.sea.ql.parser.antlr;

import java.lang.reflect.Method;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

public abstract class ANTLRParser implements IParser {
	public Object parseInput(String input, String methodName) throws ParseError {
		try {
			QLParser parser = getParser(input);
			Method method = parser.getClass().getMethod(methodName, new Class[] { });
			return method.invoke(parser, new Object[]{ });
		} catch (Exception e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	private QLParser getParser(String input)
	{
		ANTLRStringStream stream = new ANTLRStringStream(input);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}
}