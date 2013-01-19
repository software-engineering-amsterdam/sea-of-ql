package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;

public class TestUnaryOperators extends TestBase {
	@Test
	public void testNeg() throws RecognitionException {
		assertEquals(Neg.class, parse("-1").unExpression().getClass());
		assertEquals(Neg.class, parse("-(3*2)").unExpression().getClass());
		assertNotEquals(Neg.class, parse("2 - 2").unExpression().getClass());
	}
	
	@Test
	public void testNot() throws RecognitionException {
		assertEquals(Not.class, parse("!(ident)").unExpression().getClass());
		assertEquals(Not.class, parse("!(2 == 2)").unExpression().getClass());
		assertNotEquals(Not.class, parse("2!").unExpression().getClass());		
	}
	
	@Test
	public void testPos() throws RecognitionException {
		assertEquals(Pos.class, parse("+1").unExpression().getClass());
		assertEquals(Pos.class, parse("+(3*2)").unExpression().getClass());
		assertNotEquals(Pos.class, parse("2 + 2").unExpression().getClass());		
	}
}
