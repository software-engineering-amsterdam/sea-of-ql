package org.uva.sea.ql.tests.semantic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.visitor.FormVisitor;
import org.uva.sea.ql.visitor.SymbolTable;

@RunWith(Parameterized.class)
public class TestForm {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static SymbolTable symbolTable = new SymbolTable();
	public static ArrayList<Message> errors = new ArrayList<Message>();
	private String formString = "form Box1HouseOwning {\n"
			+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
			+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
			+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
			+ "   if (hasSoldHouse) {\n"
			+ "     sellingPrice: \"Price the house was sold for:\" integer\n"
			+ "     privateDebt: \"Private debts for the sold house:\" integer\n"
			+ "     valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n"
			+ "   }\n" + "}\n";

	
	public TestForm(IParse parser) {
		this.parser = parser;
		symbolTable = new SymbolTable();
		errors = new ArrayList<Message>();
	}

	@Test
	public void testProvidedForm() throws ParseError {
		parser.parseForm(formString).accept(new FormVisitor(symbolTable, errors));
    	assertEquals(errors.size(), 0);
	}
}
