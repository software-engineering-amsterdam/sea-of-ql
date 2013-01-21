package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.UnaryExpr;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.literal.Int;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.CurrentTest;
import org.uva.sea.ql.test.common.MathOperation;
import org.uva.sea.ql.test.common.Operation;

public class TestLogical extends TestExpressions {
	@Test
	public void testAnd() throws ParseError {
		new Operation(And.class).testBools(new Operation(LT.class));
	}

	@Test
	public void TestAndWithOr() throws ParseError {
		new Operation(And.class).testBools(new Operation(Or.class));
	}

	@Test
	public void testOr() throws ParseError {
		new Operation(Or.class).testBools(new Operation(LT.class));
	}

	@Test
	public void TestOrWithAnd() throws ParseError {
		new Operation(Or.class).testBools(new Operation(And.class));
	}

	@Test
	public void testComplexBooleans() throws ParseError {
		new Operation(Or.class).testComplexBools(new Operation(And.class));
		new Operation(And.class).testComplexBools(new Operation(Or.class));
		new Operation(Or.class).testComplexBools(new Operation(Or.class));
		new Operation(And.class).testComplexBools(new Operation(And.class));
	}

	@Test
	public void testBooleanPrecedence() throws ParseError {
		new MathOperation(Or.class).testMathOperations(new MathOperation(
				And.class));
		new MathOperation(And.class).testMathOperations(new MathOperation(
				Or.class));
	}

	@Test
	public void testNeg() throws ParseError {
		new Operation(Neg.class).testUnary();
	}

	@Test
	public void testPosAndNeg() throws ParseError {
		Expr e = CurrentTest.parse("-1");
		assertEquals(Neg.class, e.getClass());
		UnaryExpr u = (UnaryExpr) e;
		assertEquals(Int.class, u.getAdjacent().getClass());
		Int i = (Int) u.getAdjacent();
		assertEquals(1, i.getValue());

		e = CurrentTest.parse("+1");
		assertEquals(Pos.class, e.getClass());
		u = (UnaryExpr) e;
		assertEquals(Int.class, u.getAdjacent().getClass());
		i = (Int) u.getAdjacent();
		assertEquals(1, i.getValue());
	}

	@Test
	public void testNot() throws ParseError {
		new Operation(Not.class).testUnary();
	}

}
