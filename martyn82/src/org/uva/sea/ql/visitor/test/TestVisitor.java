package org.uva.sea.ql.visitor.test;

import org.junit.Test;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.*;

/**
 * Testing visitor.
 */
public class TestVisitor {
	/**
	 * Holds the parser to use.
	 */
	private final IParser parser;
	
	/**
	 * Constructs a new TestVisitor instance.
	 */
	public TestVisitor() {
		this.parser = new JACCParser();
	}

	/**
	 * Tests the print visitor.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testPrint() throws ParseError {
		Visitor visitor = new PrintVisitor( System.out );

		String program = "" +
		"if ( a && !b ) {\n" +
			"c: boolean;\n" +
		"}\n" +
		"else {\n" +
			"c = (a && b);\n" +
			"if ( c ) {\n" +
				"c = !c;\n" +
			"};" +
		"}";
		
		this.parser.parse( program ).accept( visitor );
	}
}
