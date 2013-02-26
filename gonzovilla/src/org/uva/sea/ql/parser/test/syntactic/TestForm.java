package org.uva.sea.ql.parser.test.syntactic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestForm {
	
	private IParse parser;

	public TestForm() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testForm() throws ParseError {
		assertEquals(parser.parseForm(
			"form Box1HouseOwning { " +
			"hasSoldHouse: \"Did you sell a house in 2010?\" [Bool]" +
			"hasBoughtHouse: \"Did you buy a house in 2010\" [Bool]" +
			"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" [Bool]" +
			"if (hasSoldHouse) then { " +
			"sellingPrice: \"Price the house was sold for:\" [Int]" +
			"privateDebt: \"Private debts for the sold house:\" [Int]" +
			"valueResidue: \"Value residue:\" (sellingPrice - privateDebt) [Int] } endif}"
					).getClass(), Form.class);
		
	}
}