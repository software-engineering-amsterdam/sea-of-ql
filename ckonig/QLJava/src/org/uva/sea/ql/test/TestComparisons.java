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

	@Test
	public void testLTWithAdd() throws ParseError {
		new BoolTestHelper(LT.class).testRels(new BoolTestHelper(Add.class));
	}

	@Test
	public void testLTWithSub() throws ParseError {
		new BoolTestHelper(LT.class).testRels(new BoolTestHelper(Sub.class));
	}

	@Test
	public void testLTWithMul() throws ParseError {
		new BoolTestHelper(LT.class).testRels(new BoolTestHelper(Mul.class));
	}

	@Test
	public void testLTWithDiv() throws ParseError {
		new BoolTestHelper(LT.class).testRels(new BoolTestHelper(Div.class));
	}

	@Test
	public void testLEqWithAdd() throws ParseError {
		new BoolTestHelper(LEq.class).testRels(new BoolTestHelper(Add.class));
	}

	@Test
	public void testLEqWithSub() throws ParseError {
		new BoolTestHelper(LEq.class).testRels(new BoolTestHelper(Sub.class));
	}

	@Test
	public void testLEqWithMul() throws ParseError {
		new BoolTestHelper(LEq.class).testRels(new BoolTestHelper(Mul.class));
	}

	@Test
	public void testLEqWithDiv() throws ParseError {
		new BoolTestHelper(LEq.class).testRels(new BoolTestHelper(Div.class));
	}

	@Test
	public void testGTWithAdd() throws ParseError {
		new BoolTestHelper(GT.class).testRels(new BoolTestHelper(Add.class));
	}

	@Test
	public void testGTWithSub() throws ParseError {
		new BoolTestHelper(GT.class).testRels(new BoolTestHelper(Sub.class));
	}

	@Test
	public void testGTWithMul() throws ParseError {
		new BoolTestHelper(GT.class).testRels(new BoolTestHelper(Mul.class));
	}

	@Test
	public void testGTWithDiv() throws ParseError {
		new BoolTestHelper(GT.class).testRels(new BoolTestHelper(Div.class));
	}

	@Test
	public void testGEqWithAdd() throws ParseError {
		new BoolTestHelper(GEq.class).testRels(new BoolTestHelper(Add.class));
	}

	@Test
	public void testGEqWithSub() throws ParseError {
		new BoolTestHelper(GEq.class).testRels(new BoolTestHelper(Sub.class));
	}

	@Test
	public void testGEqWithMul() throws ParseError {
		new BoolTestHelper(GEq.class).testRels(new BoolTestHelper(Mul.class));
	}

	@Test
	public void testGEqWithDiv() throws ParseError {
		new BoolTestHelper(GEq.class).testRels(new BoolTestHelper(Div.class));
	}

	@Test
	public void testEqWithAdd() throws ParseError {
		new BoolTestHelper(Eq.class).testRels(new BoolTestHelper(Add.class));
	}

	@Test
	public void testEqWithSub() throws ParseError {
		new BoolTestHelper(Eq.class).testRels(new BoolTestHelper(Sub.class));
	}

	@Test
	public void testEqWithMul() throws ParseError {
		new BoolTestHelper(Eq.class).testRels(new BoolTestHelper(Mul.class));
	}

	@Test
	public void testEqWithDiv() throws ParseError {
		new BoolTestHelper(Eq.class).testRels(new BoolTestHelper(Div.class));
	}

	@Test
	public void testNEqWithAdd() throws ParseError {
		new BoolTestHelper(NEq.class).testRels(new BoolTestHelper(Add.class));
	}

	@Test
	public void testNEqWithSub() throws ParseError {
		new BoolTestHelper(NEq.class).testRels(new BoolTestHelper(Sub.class));
	}

	@Test
	public void testNEqWithMul() throws ParseError {
		new BoolTestHelper(NEq.class).testRels(new BoolTestHelper(Mul.class));
	}

	@Test
	public void testNEqWithDiv() throws ParseError {
		new BoolTestHelper(NEq.class).testRels(new BoolTestHelper(Div.class));
	}

}
