package org.uva.sea.ql.parser.test;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.TypeChecker;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

import junit.framework.TestCase;

public class TestTraversal extends TestCase {
	private static final String FORM = 
		"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean\nhasBoughtHouse: \"Did you buy a house in 2010?\" boolean\nif (hasSoldHouse) { sellingPrice: \"Price was sold for:\" money\nprivateDebt: \"Private debts for the sold house:\" money\nvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) } else { reasonNotSelling: \"Why did you not sell the house?\" string\n }\n age: \"How old are you?\" integer\n\n}";
	
	@Test
	public void testTypeChecker() throws RecognitionException {
		ANTLRParser parser = new ANTLRParser();
	//	parser.parseAndVisitForm(form);
		TypeChecker t = new TypeChecker();
		Node n = parser.parse("31 * 3 + 2 + 80 + 16 * 1");
		n.accept(t);
		assertTrue(true);
	}	
}
