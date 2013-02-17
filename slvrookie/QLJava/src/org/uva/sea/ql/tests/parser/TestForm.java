package org.uva.sea.ql.tests.parser;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class TestForm {

	final private IParse parser = new ANTLRParser();

	@Test
	public void testForm() throws ParseError {
		
		String form1 = "form bigBox1HouseOwning { \n "
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
				+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if (hasSoldHouse){ \n"
				+ "     sellingPrice: \"Price the house was sold for:\" int \n"
				+ "     privateDebt: \"Private debts for the sold house:\" int \n"
				+ "     valueResidue: \"Value residue:\" int(sellingPrice - priateDebt)}}";

		String form2 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" boolean \n"
				+ "   		hasSoldHouse3: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   			if ((2>3)&&(4<2)){ \n"
				+ "   				hasSoldHouse4: \"Price the house was sold for:\" int \n"
				+ "     			hasSoldHouse5:  \"Private debts for the sold house:\" int \n" 
				+ "     			hasSoldHouse6: \"Value residue:\" int((3+3)+3) \n }" 
				+ "		 				else {"
				+ "   							if (!(hasSoldHouse2||hasSoldHouse3)){ \n"
				+ "									hasSoldHouse7: \"Value residue:\" int(7-3) "
				+ "									hasSoldHouse8: \"Value residue:\" int(7-6) "
				+ "									hasSoldHouse9: \"Value residue:\" int(7-3) "
				+ "									hasSoldHouse10: \"Value residue:\" int(hasSoldHouse4)}}"
				+ "   		hasSoldHouse11: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse12: \"Did you by a house in 2010?\" boolean \n"
				+ "   		hasSoldHouse13: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   			if (!(hasSoldHouse2||hasSoldHouse3)){ \n"
				+ "   				hasSoldHouse14: \"Price the house was sold for:\" int \n"
				+ "     			hasSoldHouse15:  \"Private debts for the sold house:\" int \n" 
				+ "     			hasSoldHouse16: \"Value residue:\" int(3+1) \n"
				+ "     			hasSoldHouse17:  \"Private debts for the sold house:\" int}} \n"
				+ "   			/*	Just comments \n"
				+ "     			nothing to do here */ \n" 
				+ "     		//	xaris rwmas \n";
		
		assertEquals(Form.class, parser.parseForm(form1).getClass());
		assertEquals(Form.class, parser.parseForm(form2).getClass());
	}

}