package org.uva.sea.ql.visitor;

import org.uva.sea.ql.TextFileLoader;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.jacc.QLParser;

abstract public class VisitorTest<T> {
	protected final Parser parser;
	protected String program;

	protected VisitorTest() {
		this.parser = new QLParser();
		this.program = TextFileLoader.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );
	}
}
