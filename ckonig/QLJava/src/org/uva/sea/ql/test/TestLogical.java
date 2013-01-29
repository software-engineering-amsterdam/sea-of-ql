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
import org.uva.sea.ql.test.common.MathTestHelper;

public class TestLogical extends TestExpressions {

	private BoolTestHelper boolTestHelper;
	private MathTestHelper mathTestHelper;

	public TestLogical() {
		super();
		this.boolTestHelper = new BoolTestHelper(parser);
		this.mathTestHelper = new MathTestHelper(parser);
	}

	@Test
	public void testAnd() throws ParseError {
		boolTestHelper.setClass(And.class).testBools(
				boolTestHelper.setClass(LT.class));
	}

	@Test
	public void TestAndWithOr() throws ParseError {
		boolTestHelper.setClass(And.class).testBools(
				boolTestHelper.setClass(Or.class));
	}

	@Test
	public void testOr() throws ParseError {
		boolTestHelper.setClass(Or.class).testBools(
				boolTestHelper.setClass(LT.class));
	}

	@Test
	public void TestOrWithAnd() throws ParseError {
		boolTestHelper.setClass(Or.class).testBools(
				boolTestHelper.setClass(And.class));
	}

	@Test
	public void testComplexBooleans() throws ParseError {
		boolTestHelper.setClass(Or.class).testComplexBools(
				boolTestHelper.setClass(And.class));
		boolTestHelper.setClass(And.class).testComplexBools(
				boolTestHelper.setClass(Or.class));
		boolTestHelper.setClass(Or.class).testComplexBools(
				boolTestHelper.setClass(Or.class));
		boolTestHelper.setClass(And.class).testComplexBools(
				boolTestHelper.setClass(And.class));
	}

	@Test
	public void testBooleanPrecedence() throws ParseError {
		mathTestHelper.setClass(Or.class).testMathOperations(
				mathTestHelper.setClass(And.class));
		mathTestHelper.setClass(And.class).testMathOperations(
				mathTestHelper.setClass(Or.class));
	}

	@Test
	public void testNeg() throws ParseError {
		boolTestHelper.setClass(Neg.class).testUnary();
	}

	@Test
	public void testPosAndNeg() throws ParseError {
		Expr e = parser.parse("-1");
		assertEquals(Neg.class, e.getClass());
		UnaryExpr u = (UnaryExpr) e;
		assertEquals(IntLiteral.class, u.getAdjacent().getClass());
		IntLiteral i = (IntLiteral) u.getAdjacent();
		assertEquals(1, i.getValue());

		e = parser.parse("+1");
		assertEquals(Pos.class, e.getClass());
		u = (UnaryExpr) e;
		assertEquals(IntLiteral.class, u.getAdjacent().getClass());
		i = (IntLiteral) u.getAdjacent();
		assertEquals(1, i.getValue());
	}

	@Test
	public void testNot() throws ParseError {
		boolTestHelper.setClass(Not.class).testUnary();
	}

}
