package org.uva.sea.ql.parser.test.tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.visitor.TypeChecker;


public class TestTypeChecker {

	final private IParse parser = new ANTLRParser();
	

	@Test
	public void testTypeCheck() throws ParseError {
		TypeChecker checker = new TypeChecker();
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" boolean \n"
				+ "   		hasSoldHouse3: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   			if ( hasSoldHouse2== true){ \n"
				+ "   				hasSoldHouse4: \"Price the house was sold for:\" int \n"
				+ "     			hasSoldHouse5:  \"Private debts for the sold house:\" int \n" 
				+ "     			hasSoldHouse6: \"Value residue:\" int(7-3) \n }" 
				+ "		 				else {"
				+ "							hasSoldHouse7: \"Value residue:\" int(7-3) "
				+ "							hasSoldHouse8: \"Value residue:\" int(7-6) "
				+ "							hasSoldHouse9: \"Value residue:\" int(7-3) "
				+ "							hasSoldHouse10: \"Value residue:\" int(7-3)}"
				+ "   		hasSoldHouse11: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse12: \"Did you by a house in 2010?\" boolean \n"
				+ "   		hasSoldHouse13: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   			if ( hasSoldHouse1 + hasSoldHouse11){ \n"
				+ "   				hasSoldHouse14: \"Price the house was sold for:\" int \n"
				+ "     			hasSoldHouse15:  \"Private debts for the sold house:\" int \n" 
				+ "     			hasSoldHouse16: \"Value residue:\" int(3.00+1) \n"
				+ "     			hasSoldHouse17:  \"Private debts for the sold house:\" int}}"; 
				
		assertEquals(Form.class, parser.parseForm(form1).getClass());
		parser.parseForm(form1).accept(checker);
		for (String errorString : checker.getErrorList())
			System.out.println(errorString);
	}
	
}
