package org.uva.sea.ql.test.visitor.printer;

import java.io.IOException;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.visitor.VisitorTest;
import org.uva.sea.ql.visitor.printer.QLPrinter;

public class PrinterTest extends VisitorTest<Boolean> {
	public PrinterTest() {
		super();
	}

	@Test
	public void test() throws ParseError, IOException {
		QLPrinter printer = new QLPrinter( System.out );
		printer.print( this.parser.parse( program ) );
	}
}
