package org.uva.sea.ql.parser.test.semantic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import org.uva.sea.ql.parser.antlr.ParseError;

public class FormElementTypeTest extends AbstractFormTypeTest {

	@Override
	protected boolean typeCheck(String src) throws ParseError {
		return getParser().parseFormElement(src).accept(getTypeChecker());
	}
	
	@Test
	public void testQuestions() throws ParseError {
		assertTrue(typeCheck("otherInt: \"fjdslfj\" integer"));
		assertTrue(typeCheck("otherString: \"\" string"));
		assertTrue(typeCheck("otherBool: \"\" boolean"));
	}
	

	@Test
	public void testComputedQuestions() throws ParseError {
		assertTrue(typeCheck(
				"q1: \"label\" integer(intA)"));
		assertFalse(typeCheck(
				"q2: \"label\" integer(boolB)"));
		assertFalse(typeCheck(
				"q3: \"label\" integer(strC)"));
		
		assertFalse(typeCheck(
				"q4: \"label\" boolean(intA)"));
		assertTrue(typeCheck(
				"q5: \"label\" boolean(boolB)"));
		assertFalse(typeCheck(
				"q6: \"label\" boolean(strC)"));
		
		assertFalse(typeCheck(
				"q7: \"label\" string(intA)"));
		assertFalse(typeCheck(
				"q8: \"label\" string(boolB)"));
		assertTrue(typeCheck(
				"q9: \"label\" string(strC)"));
		
	}

	@Test
	public void testIfThenElses() throws ParseError {
		assertTrue(typeCheck(
				"if (boolB) { q1: \" \" integer }"));
		
		assertTrue(typeCheck(
				"if (boolB) { q1: \" \" integer } else if (strC == strC) { }"));
		
		assertTrue(typeCheck(
				"if (boolB) { q1: \" \" integer } else { q2: \" \" string }"));
		
		assertTrue(typeCheck(
				"if (boolB) { } else if (intA > intA) {} else {} "));
	}


	
}
