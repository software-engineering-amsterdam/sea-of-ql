package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


@RunWith(Parameterized.class)
public class TestForm {
	private IParse parser;

	@Parameters
	
	public static List<Object[]> theParser() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ANTLRParser() });
		return parserList;
	}

	public TestForm(IParse parser) {
		this.parser = parser;
	}
	
	@Test
	public void testForm() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
				+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if (hasSoldHouse) {\n"
				+ "     sellingPrice: \"Price the house was sold for:\" int \n"
				+ "     privateDebt: \"Private debts for the sold house:\" int \n"
				+ "     valueResidue: \"Value residue:\" int(sellingPrice - priateDebt)}}"
				;
		
		assertEquals(Form.class, parser.parseForm("form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean}").getClass());
		assertEquals(Form.class, parser.parseForm(form1).getClass());
	}

}