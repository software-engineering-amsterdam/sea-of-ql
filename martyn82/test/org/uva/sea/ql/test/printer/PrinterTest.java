package org.uva.sea.ql.test.printer;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.printer.PrintContext;
import org.uva.sea.ql.printer.QLPrinter;
import org.uva.sea.ql.test.visitor.VisitorTest;

/**
 * Testing visitor.
 */
public class PrinterTest extends VisitorTest<Boolean> {
	/**
	 * Constructs a new pretty printer test.
	 */
	public PrinterTest() {
		super();
	}

	/**
	 * Performs AST pretty printer on the example program string as defined in abstract parent class.
	 *
	 * @throws ParseError
	 */
	@Test
	public void test() throws ParseError {
		this.parser.parse( program ).accept(
			new QLPrinter(
				new PrintContext( System.out )
			)
		);
	}
}
