package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.parser.antlr.FormParser;

public abstract class AbstractTest {
	private FormParser parser;

	public AbstractTest() {
		parser = new FormParser();
	}
	
	protected FormParser getParser() {
		return parser;
	}
	
}
