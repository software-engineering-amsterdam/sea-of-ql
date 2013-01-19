package org.uva.sea.ql.parser.test;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

import junit.framework.TestCase;

public class TestBase {
	protected QLParser parse(final String source) {
		final ANTLRStringStream stream = new ANTLRStringStream(source);
		final CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}
	
	protected QLParser parseResource(final String path) {
		// TODO: parse resource
		return null;
	}
}
