package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.parser.test.ParseError;

public class TestRendering {
	private static String formString = "form Box1HouseOwning { \n" +
			"name: \"What is your name?\" string\n" +
            "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n" +
            "hasBoughtHouse: \"Did you by a house in 2010?\" boolean    \n"+
            "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" \n" +
            	"boolean\n" +
            "if (hasSoldHouse) {" +
            "sellingPrice: \"Price the house was sold for:\" int \n" +
            "privateDebt: \"Private debts for the sold house:\" int\n" +
            "valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n" +         
				"}\n" +
			  "}";
	
	public static void main(String[] args) throws ParseError {
		ApplicationFrame appFrame = new ApplicationFrame(formString);
		appFrame.showFrame();
	}
}