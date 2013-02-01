package org.uva.sea.ql.test.parser;

import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.jacc.QLParser;

/**
 * Abstract class for implementing parser test.
 */
abstract public class ParserTest {
	/**
	 * Holds working parser object.
	 */
	private final IParser parser;

	/**
	 * Constructs a new instance of the parser test.
	 */
	public ParserTest() {
		this.parser = new QLParser();
	}

	/**
	 * Retrieves the parser.
	 *
	 * @return The parser.
	 */
	protected IParser getParser() {
		return this.parser;
	}
}
