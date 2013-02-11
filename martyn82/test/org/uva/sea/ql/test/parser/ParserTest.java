package org.uva.sea.ql.test.parser;

import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.jacc.QLParser;

abstract public class ParserTest {
	private final IParser parser;

	public ParserTest() {
		this.parser = new QLParser();
	}

	protected IParser getParser() {
		return this.parser;
	}
}
