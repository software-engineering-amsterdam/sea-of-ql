package org.uva.sea.ql.parser.test.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.typechecking.ExpressionTypeChecker;

public class ExpressionTypeTest extends TypeTest {
	private ExpressionTypeChecker typeChecker;
	
	public ExpressionTypeTest() {
		typeChecker = new ExpressionTypeChecker(getEnvironment());
	}
	
	@Override
	protected boolean typeCheck(String src) throws ParseError {
		return getParser().parseExpression(src).accept(typeChecker);
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertTrue(typeCheck("intA + intA"));
		assertFalse(typeCheck("intA + boolB"));
		assertFalse(typeCheck("intA + strC"));
		
		assertTrue(typeCheck("boolB + boolB"));
		assertFalse(typeCheck("boolB + strC"));
		
		assertTrue(typeCheck("strC + strC"));
	}
	
	@Test
	public void testArithmetic() throws ParseError {
		/* Pos */
		assertTrue(typeCheck("+ intA"));
		assertFalse(typeCheck("+ boolB"));
		assertFalse(typeCheck("+ strC"));

		/* Neg */
		assertTrue(typeCheck("- intA"));
		assertFalse(typeCheck("- boolB"));
		assertFalse(typeCheck("- strC"));

		/* Subtracting */
		assertTrue(typeCheck("intA - intA"));
		assertFalse(typeCheck("intA - boolB"));
		assertFalse(typeCheck("intA - strC"));
		
		assertFalse(typeCheck("boolB - boolB"));
		assertFalse(typeCheck("boolB - strC"));
		
		assertFalse(typeCheck("strC - strC"));
		
		/* Multiplying */
		assertTrue(typeCheck("intA * intA"));
		assertFalse(typeCheck("intA * boolB"));
		assertFalse(typeCheck("intA * strC"));
		
		assertFalse(typeCheck("boolB * boolB"));
		assertFalse(typeCheck("boolB * strC"));
		
		assertFalse(typeCheck("strC * strC"));

		/* Dividing */
		assertTrue(typeCheck("intA / intA"));
		assertFalse(typeCheck("intA / boolB"));
		assertFalse(typeCheck("intA / strC"));
		
		assertFalse(typeCheck("boolB / boolB"));
		assertFalse(typeCheck("boolB / strC"));
		
		assertFalse(typeCheck("strC / strC"));
	}
	
	@Test
	public void testRelations() throws ParseError {
		
		/* GT */
		assertTrue(typeCheck("intA > intA"));
		assertFalse(typeCheck("intA > boolB"));
		assertFalse(typeCheck("intA > strC"));
		
		assertFalse(typeCheck("boolB > boolB"));
		assertFalse(typeCheck("boolB > strC"));
		
		assertFalse(typeCheck("strC > strC"));
		
		/* GEq */
		assertTrue(typeCheck("intA >= intA"));
		assertFalse(typeCheck("intA >= boolB"));
		assertFalse(typeCheck("intA >= strC"));
		
		assertFalse(typeCheck("boolB >= boolB"));
		assertFalse(typeCheck("boolB >= strC"));
		
		assertFalse(typeCheck("strC >= strC"));
		
		/* Equals */
		assertTrue(typeCheck("intA == intA"));
		assertFalse(typeCheck("intA == boolB"));
		assertFalse(typeCheck("intA == strC"));
		
		assertTrue(typeCheck("boolB == boolB"));
		assertFalse(typeCheck("boolB == strC"));
		
		assertTrue(typeCheck("strC == strC"));
		
		/* NEq */
		assertTrue(typeCheck("intA != intA"));
		assertFalse(typeCheck("intA != boolB"));
		assertFalse(typeCheck("intA != strC"));
		
		assertTrue(typeCheck("boolB != boolB"));
		assertFalse(typeCheck("boolB != strC"));
		
		assertTrue(typeCheck("strC != strC"));
		
		/* LEq */
		assertTrue(typeCheck("intA <= intA"));
		assertFalse(typeCheck("intA <= boolB"));
		assertFalse(typeCheck("intA <= strC"));
		
		assertFalse(typeCheck("boolB <= boolB"));
		assertFalse(typeCheck("boolB <= strC"));
		
		assertFalse(typeCheck("strC <= strC"));
		
		/* LT */
		assertTrue(typeCheck("intA < intA"));
		assertFalse(typeCheck("intA < boolB"));
		assertFalse(typeCheck("intA < strC"));
		
		assertFalse(typeCheck("boolB < boolB"));
		assertFalse(typeCheck("boolB < strC"));
		
		assertFalse(typeCheck("strC < strC"));
		
	}
	
	@Test
	public void testBools() throws ParseError {
		/* Not */
		assertFalse(typeCheck("!intA"));
		assertTrue(typeCheck("!boolB"));
		assertFalse(typeCheck("!strC"));
		
		/* And */
		assertFalse(typeCheck("intA && intA"));
		assertFalse(typeCheck("intA && boolB"));
		assertFalse(typeCheck("intA && strC"));
		
		assertTrue(typeCheck("boolB && boolB"));
		assertFalse(typeCheck("boolB && strC"));
		
		assertFalse(typeCheck("strC && strC"));
		
		/* Or */
		assertFalse(typeCheck("intA || intA"));
		assertFalse(typeCheck("intA || boolB"));
		assertFalse(typeCheck("intA || strC"));
		
		assertTrue(typeCheck("boolB || boolB"));
		assertFalse(typeCheck("boolB || strC"));
		
		assertFalse(typeCheck("strC || strC"));
	}
	
	@Test
	public void testLeaves() throws ParseError {
		assertTrue(typeCheck("intA"));
		assertTrue(typeCheck("boolB"));
		assertTrue(typeCheck("strC"));

		assertTrue(typeCheck("1"));
		assertTrue(typeCheck("\"abc\""));
	}
	
	
}
