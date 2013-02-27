package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestForms {

	private IParse parser;

	public TestForms() {
		this.parser = new ANTLRParser();
	}

	
	@Test
	public void testForm() throws ParseError {
	 	assertEquals(parser.parseForm("form Box1HouseOwning { \n" +
                                      "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n" +
                                      "hasBoughtHouse: \"Did you by a house in 2010?\" boolean    \n"+
                                      "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" \n" +
                                      	"boolean\n" +
                                      "if (hasSoldHouse) {" +
                                      "sellingPrice: \"Price the house was sold for:\" int \n" +
                                      "privateDebt: \"Private debts for the sold house:\" int\n" +
                                      "valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n" +         
										"}\n" +
									  "}").getClass(),
									  Form.class);
	 	
	}
	
}
