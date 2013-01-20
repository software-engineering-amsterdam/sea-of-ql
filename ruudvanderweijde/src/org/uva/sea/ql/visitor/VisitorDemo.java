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
    	testString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
    	testString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
    	testString += "     valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	testString += "   }\n";
    	testString += "}\n";
    	
    	ANTLRParser parser = new ANTLRParser();
		Form form = parser.parseForm(testString);
		
		//form.accept(new PrintVisitor());
		//System.out.println("----- Semantic check: ------");
		form.accept(new SemanticVisitor());
    }
}