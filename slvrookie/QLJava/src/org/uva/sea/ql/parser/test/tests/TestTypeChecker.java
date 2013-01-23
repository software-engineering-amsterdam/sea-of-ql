package org.uva.sea.ql.parser.test.tests;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.visitor.ExprVisitor;
import org.uva.sea.ql.visitor.TypeChecker;


public class TestTypeChecker {

	final private IParse parser = new ANTLRParser();
	

	@Test
	public void testDuplicateNames() throws ParseError {
		TypeChecker checker = new TypeChecker();
		String form1 = "form bigBox1HouseOwning {"
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
				+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if (hasSoldHouse) {\n"
				+ "   	privateDebt: \"Price the house was sold for:\" int \n"
				+ "     privateDebt: \"Private debts for the sold house:\" int \n"
				+ "     private: \"Value residue:\" int(sellingPrice - privateDebt)}}";
		
		String form2 = "if ((4 + 5) + 5) {\n"
				+ "   	privateDebt: \"Price the house was sold for:\" int \n}" ;
		
		String form3 = "form bigBox1HouseOwning {"
					+	"   hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
					+  "   haSoldHouse: \"Did you by a house in 2010?\" boolean \n}";
	//	parser.parseForm(form3).accept(checker);
		parser.parseFormElement(form2).accept(checker);
	//	parser.parseExpr(" ((true >3 ) && (10 < 11)) + (3 || (3>2))").accept(checker);
//		parser.parseExpr(" +(3+2) ").accept(checker);
		
		for (String errors : checker.getErrorList())
			System.out.println(errors);
	}
	
}
