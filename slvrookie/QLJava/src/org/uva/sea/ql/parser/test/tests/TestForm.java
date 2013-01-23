package org.uva.sea.ql.parser.test.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.*;

public class TestForm {

	final private IParse parser = new ANTLRParser();

	@Test
	public void testForm() throws ParseError {
		String form1 = "form bigBox1HouseOwning { \n "
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
				+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if (hasSoldHouse) {\n"
				+ "     sellingPrice: \"Price the house was sold for:\" int \n"
				+ "     privateDebt: \"Private debts for the sold house:\" int \n"
				+ "     valueResidue: \"Value residue:\" int(sellingPrice - priateDebt)}}";

		assertEquals(Form.class, parser.parseForm("form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean}").getClass());
		assertEquals(Form.class, parser.parseForm(form1).getClass());
	}

}