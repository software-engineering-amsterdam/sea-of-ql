package org.uva.sea.ql.visitor.printer.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.printer.ExpressionPrinter;
import org.uva.sea.ql.visitor.printer.StatementPrinter;
import org.uva.sea.ql.visitor.test.VisitorTest;

/**
 * Testing visitor.
 */
public class TestPrintVisitor extends VisitorTest<Boolean> {
	/**
	 * Constructs a new pretty printer test.
	 */
	public TestPrintVisitor() {
		super();
	}

	/**
	 * Performs AST pretty printer on the example program string as defined in abstract parent class.
	 *
	 * @throws ParseError
	 */
	@Test
	public void test() throws ParseError {
		ExpressionPrinter expressionVisitor = new ExpressionPrinter( System.out );
		StatementPrinter statementVisitor = new StatementPrinter( System.out, expressionVisitor );

		this.parser.parse( program ).accept( statementVisitor );
	}
}
