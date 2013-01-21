package org.uva.sea.ql.parser.test.tests;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.TypeChecker;

public class TestTypeChecker {

	final private IParse parser = new ANTLRParser();
	final private TypeChecker checker = new TypeChecker();
	final private Context context = new Context();

	@Test
	public void testDuplicateNames() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
				+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if (hasSoldHouse) {\n"
				+ "   	privateDebt: \"Price the house was sold for:\" int \n"
				+ "     privateDebt: \"Private debts for the sold house:\" int \n"
				+ "     private: \"Value residue:\" int(sellingPrice - privateDebt)}}";
		
		parser.parseForm(form1).accept(checker, context);
		parser.parseExpr("5 +5").accept(checker, context);
		parser.parseExpr("true || true").accept(checker, context);
	}
	
}
