package org.uva.sea.ql.test.parser;

import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.jacc.QLParser;

abstract public class ParserTest {
	private final Parser parser;

	public ParserTest() {
		this.parser = new QLParser();
	}

	protected Parser getParser() {
		return this.parser;
	}
}
