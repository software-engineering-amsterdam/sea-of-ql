package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;

// Test unary operations
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

	@Test
	public void testBaseClass() {
		final Expression node = mock(Expression.class);
		final UnaryOperator operator = mock(UnaryOperator.class);
		when(operator.getExpression()).thenReturn(node);

		assertEquals(operator.getExpression(), node);
		verify(operator).getExpression();
	}
}
