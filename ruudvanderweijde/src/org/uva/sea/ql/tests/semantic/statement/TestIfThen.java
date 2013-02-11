package org.uva.sea.ql.tests.semantic.statement;

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
public class TestIfThen {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public SymbolTable symbolTable = new SymbolTable();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestIfThen(IParse parser) {
		this.parser = parser;
		symbolTable = new SymbolTable();
		errors.clear();
	}

	@Test
	public void testValidCondition() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
    	formString += "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n";
    	formString += "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n";
    	formString += "   if (hasSoldHouse) {\n";
    	formString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
    	formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
    	formString += "     valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	formString += "   }\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormVisitor(symbolTable, errors));
    	assertEquals(errors.size(), 0);
	}
	@Test
	public void testNestedCondition() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "   if (true) {\n";
		formString += "   	if (true) {\n";
		formString += "   	  if (true) {\n";
		formString += "         if (true) {\n";
		formString += "           if (true) {\n";
		formString += "             if (true) {\n";
    	formString += "               sellingPrice: \"Price the house was sold for:\" integer\n";
    	formString += "             }\n";
    	formString += "           }\n";
    	formString += "         }\n";
    	formString += "       }\n";
    	formString += "     }\n";
    	formString += "   }\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormVisitor(symbolTable, errors));
    	assertEquals(errors.size(), 0);
	}
}
