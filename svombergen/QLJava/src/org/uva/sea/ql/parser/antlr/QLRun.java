package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Form;

public class QLRun {

	public static void main(String[] args) throws Exception {
		ANTLRParser parser = new ANTLRParser();
		Form f = parser.parseForm("form abc {ding1:\"ding\" boolean}");
		//System.out.println("parse: " + parser.parse("3 * (2+3+4+5+6)"));
		System.out.println("parse: " + f);
		//System.out.println("parse: " + parser.parseForm("form Box1HouseOwning {\n	hasSoldHouse: “Did you sell a house in 2010?” boolean\n   hasBoughtHouse: “Did you by a house in 2010?” boolean\n   hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?”\nboolean\n   if (hasSoldHouse) {\n     sellingPrice: “Price the house was sold for:” money\n     privateDebt: “Private debts for the sold house:” money\n     valueResidue: “Value residue:” money(sellingPrice - privateDebt)\n   }\n}"));
	}

}
