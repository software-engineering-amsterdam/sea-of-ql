package org.uva.sea.ql.parser.test.tests;


import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.visitor.TypeChecker;


public class TestTypeChecker {

	final private IParse parser = new ANTLRParser();
	

	@Test
	public void testDuplicateNames() throws ParseError {
		TypeChecker checker = new TypeChecker();
		String form1 = "form bigBox1HouseOwning {"
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" int \n"
				+ "   asSoldHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if ( asSoldHouse== true){ \n"
				+ "   	sSoldHouse: \"Price the house was sold for:\" int \n"
				+ "     privateDebt:  \"Private debts for the sold house:\" boolean" 
				+ "     privateDeb: \"Value residue:\" int(7)}}";
		
		parser.parseForm(form1).accept(checker);
		for (String errorString : checker.getErrorList())
			System.out.println(errorString);
	}
	
}
