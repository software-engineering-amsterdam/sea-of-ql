package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.MathTestHelper;

public class TestMath extends TestExpressions {
	private MathTestHelper mathTestHelper;

	public TestMath() {
		super();
		this.mathTestHelper = new MathTestHelper(parser);
	}

	@Test
	public void testMulsWithAdd() throws ParseError {
		mathTestHelper.setClass(Mul.class).testMathOperations(
				mathTestHelper.setClass(Add.class));
	}

	@Test
	public void testMulsWithSub() throws ParseError {
		mathTestHelper.setClass(Mul.class).testMathOperations(
				mathTestHelper.setClass(Sub.class));
	}

	@Test
	public void testMulsWithDiv() throws ParseError {
		mathTestHelper.setClass(Mul.class).testMathOperations(
				mathTestHelper.setClass(Div.class));
	}

	@Test
	public void testDivsWithMul() throws ParseError {
		mathTestHelper.setClass(Div.class).testMathOperations(
				mathTestHelper.setClass(Mul.class));
	}

	@Test
	public void testDivsWithAdd() throws ParseError {
		mathTestHelper.setClass(Div.class).testMathOperations(
				mathTestHelper.setClass(Add.class));
	}

	@Test
	public void testDivsWithSub() throws ParseError {
		mathTestHelper.setClass(Div.class).testMathOperations(
				mathTestHelper.setClass(Sub.class));
	}

	@Test
	public void testAddsWithMul() throws ParseError {
		mathTestHelper.setClass(Add.class).testMathOperations(
				mathTestHelper.setClass(Mul.class));
	}

	@Test
	public void testAddsWithDiv() throws ParseError {
		mathTestHelper.setClass(Add.class).testMathOperations(
				mathTestHelper.setClass(Div.class));
	}

	@Test
	public void testAddsWithSub() throws ParseError {
		mathTestHelper.setClass(Add.class).testMathOperations(
				mathTestHelper.setClass(Sub.class));
	}

	@Test
	public void testSubsWithMul() throws ParseError {
		mathTestHelper.setClass(Sub.class).testMathOperations(
				mathTestHelper.setClass(Mul.class));
	}

	@Test
	public void testSubsWithAdd() throws ParseError {
		mathTestHelper.setClass(Sub.class).testMathOperations(
				mathTestHelper.setClass(Add.class));
	}

	@Test
	public void testSubsWithDiv() throws ParseError {
		mathTestHelper.setClass(Sub.class).testMathOperations(
				mathTestHelper.setClass(Div.class));
	}
}
