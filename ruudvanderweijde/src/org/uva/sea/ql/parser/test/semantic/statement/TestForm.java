package org.uva.sea.ql.parser.test.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.visitor.checker.FormChecker;

@RunWith(Parameterized.class)
public class TestFormSemantics {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static HashMap<Ident, Type> ExprMap = new HashMap<Ident, Type>();
	public static ArrayList<String> errors = new ArrayList<String>();

	
	public TestFormSemantics(IParse parser) {
		this.parser = parser;
		ExprMap = new HashMap<Ident, Type>();
		errors = new ArrayList<String>();
	}

	@Test
	public void testProvidedForm() throws ParseError {
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
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 0);
	}
	
	@Test
	public void testDuplicateId() throws ParseError {
		String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 1);
		
	} 
	
	@Test
	public void testUndefinedType() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n";
    	formString += "   if (hasMaintLoan) {\n";
    	formString += "     sellingPrice1: \"Price the house was sold for:\" integer\n";
    	formString += "	  }\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 0);
	}
	
	@Test
	public void testBooleanType() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n";
    	formString += "   if (hasSoldHouse == true) {\n";
    	formString += "     sellingPrice1: \"Price the house was sold for:\" integer\n";
    	formString += "	  }\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 0);
	}

	@Test
	public void testBooleanTypeError() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n";
    	formString += "   if (hasSoldHouse > true) {\n";
    	formString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
    	formString += "	  }\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 1);
	}

	@Test
	public void testComputedQuestion() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
    	formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
    	formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 0);
	}

	@Test
	public void testComputedQuestionErrorDifferentType() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "     sellingPrice: \"Price the house was sold for:\" boolean\n";
    	formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
    	formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 1);
	}
	
	@Test
	public void testComputedQuestionErrorInvalidType() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
    	formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
    	formString += "		valueResidue: \"Value residue:\" boolean(sellingPrice - privateDebt)\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 1);
	}
	
	@Test
	public void testComputedQuestionErrorWrongType() throws ParseError {	
    	String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "     sellingPrice: \"Price the house was sold for:\" boolean\n";
    	formString += "     privateDebt: \"Private debts for the sold house:\" boolean\n";
    	formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormChecker(ExprMap, errors));
    	assertEquals(errors.size(), 1);
	}
}
