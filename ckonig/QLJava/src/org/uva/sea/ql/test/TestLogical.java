package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.BoolTestHelper;
import org.uva.sea.ql.test.common.CurrentTest;
import org.uva.sea.ql.test.common.MathTestHelper;

public class TestLogical extends TestExpressions {
	@Test
	public void testAnd() throws ParseError {
		new BoolTestHelper(And.class).testBools(new BoolTestHelper(LT.class));
	}

	@Test
	public void TestAndWithOr() throws ParseError {
		new BoolTestHelper(And.class).testBools(new BoolTestHelper(Or.class));
	}

	@Test
	public void testOr() throws ParseError {
		new BoolTestHelper(Or.class).testBools(new BoolTestHelper(LT.class));
	}

	@Test
	public void TestOrWithAnd() throws ParseError {
		new BoolTestHelper(Or.class).testBools(new BoolTestHelper(And.class));
	}

	@Test
	public void testComplexBooleans() throws ParseError {
		new BoolTestHelper(Or.class).testComplexBools(new BoolTestHelper(
				And.class));
		new BoolTestHelper(And.class).testComplexBools(new BoolTestHelper(
				Or.class));
		new BoolTestHelper(Or.class).testComplexBools(new BoolTestHelper(
				Or.class));
		new BoolTestHelper(And.class).testComplexBools(new BoolTestHelper(
				And.class));
	}

	@Test
	public void testBooleanPrecedence() throws ParseError {
		new MathTestHelper(Or.class).testMathOperations(new MathTestHelper(
				And.class));
		new MathTestHelper(And.class).testMathOperations(new MathTestHelper(
				Or.class));
	}

	@Test
	public void testNeg() throws ParseError {
		new BoolTestHelper(Neg.class).testUnary();
	}

	@Test
	public void testPosAndNeg() throws ParseError {
		Expr e = CurrentTest.parse("-1");
		assertEquals(Neg.class, e.getClass());
		UnaryExpr u = (UnaryExpr) e;
		assertEquals(IntLiteral.class, u.getAdjacent().getClass());
		IntLiteral i = (IntLiteral) u.getAdjacent();
		assertEquals(1, i.getValue());

		e = CurrentTest.parse("+1");
		assertEquals(Pos.class, e.getClass());
		u = (UnaryExpr) e;
		assertEquals(IntLiteral.class, u.getAdjacent().getClass());
		i = (IntLiteral) u.getAdjacent();
		assertEquals(1, i.getValue());
	}

	@Test
	public void testNot() throws ParseError {
		new BoolTestHelper(Not.class).testUnary();
	}

}
