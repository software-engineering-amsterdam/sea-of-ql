package org.uva.sea.ql.visitor.test;

import org.junit.Test;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.visitor.INodeVisitor;
import org.uva.sea.ql.visitor.PrintVisitor;

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

		program =
			"form Box1HouseOwning {\n" +
				"\t\"Did you sell a house in 2010?\" hasSoldHouse : boolean\n" +
				"\t\"Did you buy a house in 2010?\" hasBoughtHouse: boolean\n" +
				"\t\"Did you enter a loan for maintainance/reconstruction?\" hasMaintLoan: boolean\n" +
				"\tif ( hasSoldHouse ) {\n" +
				"\t\t\"Private debts for the sold house:\" privateDebt: money\n" +
				"\t\t\"Price the house was sold for:\" sellingPrice: money\n" +
				"\t\t\"Value residue:\" valueResidue = sellingPrice - privateDebt\n" +
				"\t}\n" +
			"}";

		program = "if ( true ) { } else { }";

		this.parser.parse( program ).accept( visitor );
	}
}
