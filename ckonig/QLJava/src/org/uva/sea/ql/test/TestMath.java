package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.MathTestHelper;

public class TestMath extends TestExpressions {
	@Test
	public void testMulsWithAdd() throws ParseError {
		new MathTestHelper(Mul.class).testMathOperations(new MathTestHelper(
				Add.class));
	}

	@Test
	public void testMulsWithSub() throws ParseError {
		new MathTestHelper(Mul.class).testMathOperations(new MathTestHelper(
				Sub.class));
	}

	@Test
	public void testMulsWithDiv() throws ParseError {
		new MathTestHelper(Mul.class).testMathOperations(new MathTestHelper(
				Div.class));
	}

	@Test
	public void testDivsWithMul() throws ParseError {
		new MathTestHelper(Div.class).testMathOperations(new MathTestHelper(
				Mul.class));
	}

	@Test
	public void testDivsWithAdd() throws ParseError {
		new MathTestHelper(Div.class).testMathOperations(new MathTestHelper(
				Add.class));
	}

	@Test
	public void testDivsWithSub() throws ParseError {
		new MathTestHelper(Div.class).testMathOperations(new MathTestHelper(
				Sub.class));
	}

	@Test
	public void testAddsWithMul() throws ParseError {
		new MathTestHelper(Add.class).testMathOperations(new MathTestHelper(
				Mul.class));
	}

	@Test
	public void testAddsWithDiv() throws ParseError {
		new MathTestHelper(Add.class).testMathOperations(new MathTestHelper(
				Div.class));
	}

	@Test
	public void testAddsWithSub() throws ParseError {
		new MathTestHelper(Add.class).testMathOperations(new MathTestHelper(
				Sub.class));
	}

	@Test
	public void testSubsWithMul() throws ParseError {
		new MathTestHelper(Sub.class).testMathOperations(new MathTestHelper(
				Mul.class));
	}

	@Test
	public void testSubsWithAdd() throws ParseError {
		new MathTestHelper(Sub.class).testMathOperations(new MathTestHelper(
				Add.class));
	}

	@Test
	public void testSubsWithDiv() throws ParseError {
		new MathTestHelper(Sub.class).testMathOperations(new MathTestHelper(
				Div.class));
	}

}
