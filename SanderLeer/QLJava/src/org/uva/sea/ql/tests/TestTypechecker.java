package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.*;
import org.uva.sea.ql.parser.jacc.*;
import org.uva.sea.ql.typechecker.TypeChecker;

public class TestTypechecker {

	private Parser parser;
	private TypeChecker checker;

	public TestTypechecker() {
		this.parser = new JACCParser();
		this.checker = new TypeChecker();
	}
	
	// helper method to assert source 's' type checks 'expected'
	private void test(boolean expected, String s) throws ParseException {
		ASTNode ast = parser.parse(s);
		boolean result = checker.Check(ast); 
		if (!result) {
			System.err.println(checker.getErrors());
		}
		assertEquals(expected, result);
	}

	@Test
	public void testSymbols() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer if (id1 == 3) { id2: \"Value 2?\" integer } }");

		test(false, "form form1 { sameid: \"Value?\" integer if (sameid == 3) { sameid: \"Value 2?\" integer } }");
		test(false, "form form1 { q1: \"Value?\" integer if (notusedyet == 3) { q2: \"Value 2?\" integer } }");
		test(false, "form form1 { q1: \"Value?\" integer(notusedyet - 3) }");
		test(false, "form form1 { sameid: \"Value?\" integer if (notusedyet == 3) { sameid: \"Value 2?\" integer } }");
	}
}
