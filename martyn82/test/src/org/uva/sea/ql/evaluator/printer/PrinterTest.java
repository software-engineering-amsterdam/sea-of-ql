package org.uva.sea.ql.evaluator.printer;

import java.io.IOException;

import org.junit.Test;
import org.uva.sea.ql.evaluator.printer.ConsolePrinter;
import org.uva.sea.ql.evaluator.printer.Printer;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.VisitorTest;

public class PrinterTest extends VisitorTest<Boolean> {
	public PrinterTest() {
		super();
	}

	@Test
	public void test() throws ParseError, IOException {
		Printer printer = new ConsolePrinter();
		printer.print( this.parser.parse( program ) );
	}
}
