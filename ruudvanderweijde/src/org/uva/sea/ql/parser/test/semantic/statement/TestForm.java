package org.uva.sea.ql.parser.test.semantic.statement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.visitor.FormVisitor;

@RunWith(Parameterized.class)
public class TestForm {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static HashMap<Ident, Type> ExprMap = new HashMap<Ident, Type>();
	public static ArrayList<String> errors = new ArrayList<String>();
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
		ExprMap = new HashMap<Ident, Type>();
		errors = new ArrayList<String>();
	}

	@Test
	public void testProvidedForm() throws ParseError {
		parser.parseForm(formString).accept(new FormVisitor(ExprMap, errors));
    	assertEquals(errors.size(), 0);
	}
}
