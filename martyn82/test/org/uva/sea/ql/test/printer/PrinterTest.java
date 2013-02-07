package org.uva.sea.ql.test.printer;

import java.io.IOException;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.visitor.VisitorTest;
import org.uva.sea.ql.visitor.printer.QLPrinter;

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
	public void test() throws ParseError, IOException {
		QLPrinter printer = new QLPrinter( System.out );
		printer.print( this.parser.parse( program ) );
	}
}
