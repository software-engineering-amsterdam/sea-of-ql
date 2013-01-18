package org.uva.sea.ql.visitor.test;

import org.junit.Test;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.*;

/**
 * Testing visitor.
 */
public class TestPrintVisitor {
	/**
	 * Holds the parser to use.
	 */
	private final IParser parser;
	
	/**
	 * Constructs a new TestVisitor instance.
	 */
	public TestPrintVisitor() {
		this.parser = new JACCParser();
	}

	/**
	 * Tests the print visitor.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testPrint() throws ParseError {
		INodeVisitor visitor = new PrintVisitor( System.out );

		String program = "" +
		"if ( a && !b ) {\n" +
			"c: boolean;\n" +
		"}\n" +
		"else {\n" +
			"c = (a && b);\n" +
			"if ( c ) {\n" +
				"c = !c;\n" +
			"}" +
		"}";
		
		this.parser.parse( program ).accept( visitor );
	}
}
