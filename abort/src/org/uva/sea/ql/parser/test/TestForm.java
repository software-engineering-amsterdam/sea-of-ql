package org.uva.sea.ql.parser.test;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.TypeChecker;
import org.uva.sea.ql.parser.antlr.QLParserController;

import junit.framework.TestCase;

public class TestForm extends TestCase {
	private static final String FORM = 
			"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean\nhasBoughtHouse: \"Did you buy a house in 2010?\" boolean\nif (hasSoldHouse) { sellingPrice: \"Price was sold for:\" money\nprivateDebt: \"Private debts for the sold house:\" money\nvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) } else { reasonNotSelling: \"Why did you not sell the house?\" string\n }\n age: \"How old are you?\" integer\n\n}";
			
	private static final String INVALID_CONDITION_FORM = 
			"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean\nhasBoughtHouse: \"Did you buy a house in 2010?\" boolean\nif (applepie) { sellingPrice: \"Price was sold for:\" money\nprivateDebt: \"Private debts for the sold house:\" money\nvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) } else { reasonNotSelling: \"Why did you not sell the house?\" string\n }\n age: \"How old are you?\" integer\n\n}";
	
	private final QLParserController parser = new QLParserController();
	private final TypeChecker typeChecker = new TypeChecker();
	
	@Test
	public void testComputation() {
		
	}
	
	@Test
	public void testElement() {
		
	}
	
	@Test
	public void testValidForm() throws RecognitionException {
		parser.parseForm(FORM).accept(typeChecker);
		assertTrue(typeChecker.getErrorLog().getLength() == 0);
	}

	@Test
	public void testInvalidForm() throws RecognitionException {
		parser.parseForm(INVALID_CONDITION_FORM).accept(typeChecker);	
		assertFalse(typeChecker.getErrorLog().getLength() == 0);
	}
	
	@Test
	public void testQuestion() {
		
	}
}
