package org.uva.sea.ql.visitor.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.print.PrintVisitor;

/**
 * Testing visitor.
 */
public class TestPrintVisitor extends VisitorTest {
	/**
	 * Constructs a new pretty printer test.
	 */
	public TestPrintVisitor() {
		super( new PrintVisitor( System.out ) );
	}

	/**
	 * Tests the print visitor.
	 *
	 * @throws ParseError
	 */
	@Test
	public void test() throws ParseError {
		this.parser.parse( program ).accept( visitor, null );
	}
}
