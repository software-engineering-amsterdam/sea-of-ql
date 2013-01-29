package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.HashMap;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;

/*
 * This file is added to test visitors
 * and will be removed in the future 
 * and replaced by decent unittests.
 */
public class RunForm {

	static public void main(String[] args) throws ParseError {
		ANTLRParser parser = new ANTLRParser();

		HashMap<Ident, Type> SymbolTable = new HashMap<Ident, Type>();
		ArrayList<String> errors = new ArrayList<String>();

		// full form check
		String testString = "";
		testString += "form Box1HouseOwning {\n";
		testString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n";
		testString += "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n";
		testString += "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n";
		testString += "   if (hasSoldHouse == true) {\n";
		testString += "     sellingPrice1: \"Price the house was sold for:\" integer\n";
		testString += "   	if (anotherIf) {\n";
		testString += "     	sellingPrice4: \"Price the house was sold for:\" integer\n";
		testString += "   	}\n";
		testString += "     privateDebt1: \"Private debts for the sold house:\" integer\n";
		testString += "     valueResidue1: \"Value residue:\" integer(sellingPrice1 - privateDebt1)\n";
		testString += "	  } else {\n";
		testString += "     sellingPrice2: \"Price the house was sold for:\" integer\n";
		testString += "     privateDebt2: \"Private debts for the sold house:\" integer\n";
		testString += "     valueResidue2: \"Value residue:\" boolean(sellingPrice2 - privateDebt2)\n";
		testString += "   }\n";
		testString += "   finalQuestion: \"Please confirm that you have filled in everything correctly?\" boolean\n";
		testString += "   terms: \"I accept the terms... etc\" boolean\n";
		testString += "}\n";

		Form form = parser.parseForm(testString);
		System.out.println("----- Now running FormChecker: ------");
		form.accept(new FormVisitor(SymbolTable, errors));
		System.out.println("----- Done! Issues gevonden: " + errors.size()
				+ " ------");
		for (String msg : errors) {
			System.out.println("\t Error found:" + msg);
		}
	}
}