package org.uva.sea.ql.visitor.test;

import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Implements basic functionality of visitor test classes.
 * @param <T>
 */
abstract public class VisitorTest<T> {
	/**
	 * Holds the parser object.
	 */
	protected final IParser parser;

	/**
	 * Holds the visitor to use.
	 */
	protected final NodeVisitor<T> visitor;

	/**
	 * Holds the program source to use.
	 */
	protected String program;

	/**
	 * Constructs a new VisitorTest instance.
	 *
	 * @param visitor
	 */
	protected VisitorTest( NodeVisitor<T> visitor ) {
		this.parser = new JACCParser();
		this.visitor = visitor;

		init();
	}

	private void init() {
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
	}
}
