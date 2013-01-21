package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;


public class VisitorDemo {
	
    static public void main(String[] args) throws ParseError{
    	String testString = "";
    	testString += "form Box1HouseOwning {\n";
    	testString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
    	testString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
    	testString += "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n";
    	testString += "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n";
    	testString += "   if (hasSoldHouse == true) {\n";
    	testString += "     sellingPrice1: \"Price the house was sold for:\" integer\n";
    	testString += "     privateDebt1: \"Private debts for the sold house:\" integer\n";
    	testString += "     valueResidue1: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	testString += "	  } else {\n";
    	testString += "     sellingPrice2: \"Price the house was sold for:\" integer\n";
    	testString += "     privateDebt2: \"Private debts for the sold house:\" integer\n";
    	testString += "     valueResidue2: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	testString += "   }\n";
    	testString += "   finalQuestion: \"Please confirm that you have filled in everything correctly?\" boolean\n";
    	testString += "   terms: \"I accept the terms... etc\" boolean\n";
    	testString += "}\n";
    	
    	ANTLRParser parser = new ANTLRParser();
		Form form = parser.parseForm(testString);
		
		form.accept(new PrintFormVisitor());
		//System.out.println("----- Semantic check: ------");
//		form.accept(new SemanticChecker());
    }
}