package org.uva.sea.ql.parser.test;

import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

class TestBase {
	protected QLParser parse(final String source) {
		final ANTLRStringStream stream = new ANTLRStringStream(source);
		final CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}
	
	protected Form parseFormFromResource(final String path) throws IOException, RecognitionException {
		final ANTLRInputStream stream = new ANTLRInputStream(getClass().getClassLoader().getResourceAsStream(path));
		final CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return (new QLParser(tokens)).form();
	}
}
