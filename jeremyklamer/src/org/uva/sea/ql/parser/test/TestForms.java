package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.type.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


@RunWith(Parameterized.class)
public class TestForms {
	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> retVal = new ArrayList<Object[]>();
		retVal.add(new Object[] {new ANTLRParser()});
		return retVal;
	}
	
	public TestForms(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testBasicForms() throws ParseError {
		assertEquals(Form.class,parser.parseForm("form basicForm1 { question1 : \"Is everything ok? \" boolean }").getClass());
		assertEquals(Form.class,parser.parseForm("form basicForm2 { question1 : \"How much does a burge cost? \" money }").getClass());
		assertEquals(Form.class,parser.parseForm("form basicForm2 { question1 : \"Total money spent: \" money( 5 * 18) }").getClass());
	}
	
	@Test
	public void testComplForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm("" +
				"form testForm1 { question1 : \"How are you? \" boolean " +
				"question2 : \"Good? \" money " +
				"question3 : \"Better? \" money(8 * 7) " + 
				"question4 : \"Best? \" boolean }").getClass());
	}
	
	@Test
	public void testIfForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" money(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(13 - 5) " +
						"} " +
					"}").getClass());
	}
	
	@Test
	public void testIfThenForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" money(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(13 - 5) " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" money " +
						"} " +
					"}").getClass());
	}
	
	@Test
	public void testNestedIfForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" money(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(13 - 5) " +
						"if (hasSoldHouse) {" +
							"sellingPrice: \"Price the house was sold for:\" money " +
							"privateDebt: \"Private debts for the sold house:\" money " +
							"valueResidue: \"Value residue:\" money(13 - 5) " +
							"} " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" money " +
						"} " +
					"}").getClass());
	}

}
