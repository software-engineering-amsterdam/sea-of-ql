package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.MathOperation;

public class TestMath extends TestExpressions {
	@Test
	public void testMulsWithAdd() throws ParseError {
		new MathOperation(Mul.class).testMathOperations(new MathOperation(
				Add.class));
	}

	@Test
	public void testMulsWithSub() throws ParseError {
		new MathOperation(Mul.class).testMathOperations(new MathOperation(
				Sub.class));
	}

	@Test
	public void testMulsWithDiv() throws ParseError {
		new MathOperation(Mul.class).testMathOperations(new MathOperation(
				Div.class));
	}

	@Test
	public void testDivsWithMul() throws ParseError {
		new MathOperation(Div.class).testMathOperations(new MathOperation(
				Mul.class));
	}

	@Test
	public void testDivsWithAdd() throws ParseError {
		new MathOperation(Div.class).testMathOperations(new MathOperation(
				Add.class));
	}

	@Test
	public void testDivsWithSub() throws ParseError {
		new MathOperation(Div.class).testMathOperations(new MathOperation(
				Sub.class));
	}

	@Test
	public void testAddsWithMul() throws ParseError {
		new MathOperation(Add.class).testMathOperations(new MathOperation(
				Mul.class));
	}

	@Test
	public void testAddsWithDiv() throws ParseError {
		new MathOperation(Add.class).testMathOperations(new MathOperation(
				Div.class));
	}

	@Test
	public void testAddsWithSub() throws ParseError {
		new MathOperation(Add.class).testMathOperations(new MathOperation(
				Sub.class));
	}

	@Test
	public void testSubsWithMul() throws ParseError {
		new MathOperation(Sub.class).testMathOperations(new MathOperation(
				Mul.class));
	}

	@Test
	public void testSubsWithAdd() throws ParseError {
		new MathOperation(Sub.class).testMathOperations(new MathOperation(
				Add.class));
	}

	@Test
	public void testSubsWithDiv() throws ParseError {
		new MathOperation(Sub.class).testMathOperations(new MathOperation(
				Div.class));
	}

}
