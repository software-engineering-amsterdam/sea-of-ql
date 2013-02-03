package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.BoolTestHelper;

public class TestComparisons extends TestExpressions {
	private BoolTestHelper left;
	private BoolTestHelper right;

	public TestComparisons() {
		super();
		this.left = new BoolTestHelper(parser);
		this.right = new BoolTestHelper(parser);
	}

	@Test
	public void testLTWithAdd() throws ParseError {
		left.setClass(LT.class).testRels(right.setClass(Add.class));
	}

	@Test
	public void testLTWithSub() throws ParseError {
		left.setClass(LT.class).testRels(right.setClass(Sub.class));
	}

	@Test
	public void testLTWithMul() throws ParseError {
		left.setClass(LT.class).testRels(right.setClass(Mul.class));
	}

	@Test
	public void testLTWithDiv() throws ParseError {
		left.setClass(LT.class).testRels(right.setClass(Div.class));
	}

	@Test
	public void testLEqWithAdd() throws ParseError {
		left.setClass(LEq.class).testRels(right.setClass(Add.class));
	}

	@Test
	public void testLEqWithSub() throws ParseError {
		left.setClass(LEq.class).testRels(right.setClass(Sub.class));
	}

	@Test
	public void testLEqWithMul() throws ParseError {
		left.setClass(LEq.class).testRels(right.setClass(Mul.class));
	}

	@Test
	public void testLEqWithDiv() throws ParseError {
		left.setClass(LEq.class).testRels(right.setClass(Div.class));
	}

	@Test
	public void testGTWithAdd() throws ParseError {
		left.setClass(GT.class).testRels(right.setClass(Add.class));
	}

	@Test
	public void testGTWithSub() throws ParseError {
		left.setClass(GT.class).testRels(right.setClass(Sub.class));
	}

	@Test
	public void testGTWithMul() throws ParseError {
		left.setClass(GT.class).testRels(right.setClass(Mul.class));
	}

	@Test
	public void testGTWithDiv() throws ParseError {
		left.setClass(GT.class).testRels(right.setClass(Div.class));
	}

	@Test
	public void testGEqWithAdd() throws ParseError {
		left.setClass(GEq.class).testRels(right.setClass(Add.class));
	}

	@Test
	public void testGEqWithSub() throws ParseError {
		left.setClass(GEq.class).testRels(right.setClass(Sub.class));
	}

	@Test
	public void testGEqWithMul() throws ParseError {
		left.setClass(GEq.class).testRels(right.setClass(Mul.class));
	}

	@Test
	public void testGEqWithDiv() throws ParseError {
		left.setClass(GEq.class).testRels(right.setClass(Div.class));
	}

	@Test
	public void testEqWithAdd() throws ParseError {
		left.setClass(Eq.class).testRels(right.setClass(Add.class));
	}

	@Test
	public void testEqWithSub() throws ParseError {
		left.setClass(Eq.class).testRels(right.setClass(Sub.class));
	}

	@Test
	public void testEqWithMul() throws ParseError {
		left.setClass(Eq.class).testRels(right.setClass(Mul.class));
	}

	@Test
	public void testEqWithDiv() throws ParseError {
		left.setClass(Eq.class).testRels(right.setClass(Div.class));
	}

	@Test
	public void testNEqWithAdd() throws ParseError {
		left.setClass(NEq.class).testRels(right.setClass(Add.class));
	}

	@Test
	public void testNEqWithSub() throws ParseError {
		left.setClass(NEq.class).testRels(right.setClass(Sub.class));
	}

	@Test
	public void testNEqWithMul() throws ParseError {
		left.setClass(NEq.class).testRels(right.setClass(Mul.class));
	}

	@Test
	public void testNEqWithDiv() throws ParseError {
		left.setClass(NEq.class).testRels(right.setClass(Div.class));
	}

}
