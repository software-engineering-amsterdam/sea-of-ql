package org.uva.sea.ql.parser.test.tests;

import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.types.Type;
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
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" int \n"
				+ "   hasSolHouse: \"Did you by a house in 2010?\" boolean \n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"boolean \n"
				+ "   if (false && true){ \n"
				+ "   	hasSoldHous: \"Price the house was sold for:\" int \n"
				+ "     privateDebt:  \"Private debts for the sold house:\" boolean" 
				+ "     privateDeb: \"Value residue:\" boolean((privateDebt&&(hasSolHouse||true))||(privateDebt&&hasSoldHouse))}}";
		
		String form2 = "if ((4 + 5) + 5) {\n"
				+ "   	privateDebt: \"Price the house was sold for:\" int \n}" ;
		
		String form3 = "form bigBox1HouseOwning {"
					+	"   hasSoldHous: \"Did you sell a house in 2010?\" boolean \n"
					+  "   	hasSoldHous: \"Did you by a house in 2010?\" boolean \n"
					+  "   	hasSoldHouse: \"Did you by a house in 2010?\" boolean  \n }";
		parser.parseForm(form1).accept(checker);
	//	parser.parseFormElement(form3).accept(checker);
	//	parser.parseExpr(" ((true >3 ) && (10 < 11)) + (3 || (3>2))").accept(checker);
//		parser.parseExpr(" +(3+2) ").accept(checker);
	
		for (String errorSting : checker.getErrorList())
			System.out.println(errorSting);
	}
	
}
