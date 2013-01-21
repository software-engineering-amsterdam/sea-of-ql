package org.uva.sea.ql.visitor.printer.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.printer.PrintVisitor;
import org.uva.sea.ql.visitor.test.VisitorTest;

/**
 * Testing visitor.
 */
public class TestPrintVisitor extends VisitorTest<java.lang.Boolean> {
	/**
	 * Constructs a new pretty printer test.
	 */
	public TestPrintVisitor() {
		super( new PrintVisitor( System.out ) );
	}

	/**
	 * Performs AST pretty printer on the example program string as defined in abstract parent class.
	 *
	 * @throws ParseError
	 */
	@Test
	public void test() throws ParseError {
		this.parser.parse( program ).accept( visitor, null );
	}
}
