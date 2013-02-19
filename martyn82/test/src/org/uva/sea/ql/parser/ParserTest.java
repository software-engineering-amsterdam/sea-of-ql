package org.uva.sea.ql.parser;

import org.uva.sea.ql.parser.jacc.QLParser;

abstract class ParserTest {
	private final Parser parser;

	public ParserTest() {
		this.parser = new QLParser();
	}

	protected Parser getParser() {
		return this.parser;
	}
}
