package org.uva.sea.ql;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.visitor.FormVisitor;

/*
 * This file is added to test visitors
 * and will be removed in the future 
 * and replaced by decent unittests.
 */
public class RunForm extends JFrame  {
	private static final long serialVersionUID = 1L;
	private static final String TEST_FORM = "form Box1HouseOwning {\n"
			+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n"
			+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
			+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
			+ "   if (hasSoldHouse == true) {\n"
			+ "     sellingPrice1: \"Price the house was sold for:\" integer\n"
			+ "   	if (anotherIf) {\n"
			+ "     	sellingPrice4: \"Price the house was sold for:\" integer\n"
			+ "   	}\n"
			+ "     privateDebt1: \"Private debts for the sold house:\" integer\n"
			+ "     valueResidue1: \"Value residue:\" integer(sellingPrice1 - privateDebt1)\n"
			+ "	  } else {\n"
			+ "     sellingPrice2: \"Price the house was sold for:\" integer\n"
			+ "     privateDebt2: \"Private debts for the sold house:\" integer\n"
			+ "     valueResidue2: \"Value residue:\" integer(sellingPrice2 - privateDebt2)\n"
			+ "   }\n"
			+ "   finalQuestion: \"Please confirm that you have filled in everything correctly?\" boolean\n"
			+ "   terms: \"I accept the terms... etc\" boolean\n" + "}\n";

	static public void main(String[] args) throws ParseError {
		ANTLRParser parser = new ANTLRParser();

		HashMap<Ident, org.uva.sea.ql.ast.type.Type> symbolTable = new HashMap<Ident, org.uva.sea.ql.ast.type.Type>();
		ArrayList<String> errors = new ArrayList<String>();

		Form form = parser.parseForm(TEST_FORM);
		form.accept(new FormVisitor(symbolTable, errors));

		if (!errors.isEmpty()) {
			System.out.println("----- Done! Issues gevonden: " + errors.size()
					+ " ------");
			for (String msg : errors) {
				System.out.println("\t Error found:" + msg);
			}
		} else {
			new SwingForm(form);
		}
	}
}