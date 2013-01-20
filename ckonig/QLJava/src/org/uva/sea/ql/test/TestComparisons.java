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
import org.uva.sea.ql.test.common.Operation;

public class TestComparisons extends TestExpressions {

	@Test
	public void testLTWithAdd() throws ParseError {
		new Operation(LT.class).testRels(new Operation(Add.class));
	}

	@Test
	public void testLTWithSub() throws ParseError {
		new Operation(LT.class).testRels(new Operation(Sub.class));
	}

	@Test
	public void testLTWithMul() throws ParseError {
		new Operation(LT.class).testRels(new Operation(Mul.class));
	}

	@Test
	public void testLTWithDiv() throws ParseError {
		new Operation(LT.class).testRels(new Operation(Div.class));
	}

	@Test
	public void testLEqWithAdd() throws ParseError {
		new Operation(LEq.class).testRels(new Operation(Add.class));
	}

	@Test
	public void testLEqWithSub() throws ParseError {
		new Operation(LEq.class).testRels(new Operation(Sub.class));
	}

	@Test
	public void testLEqWithMul() throws ParseError {
		new Operation(LEq.class).testRels(new Operation(Mul.class));
	}

	@Test
	public void testLEqWithDiv() throws ParseError {
		new Operation(LEq.class).testRels(new Operation(Div.class));
	}

	@Test
	public void testGTWithAdd() throws ParseError {
		new Operation(GT.class).testRels(new Operation(Add.class));
	}

	@Test
	public void testGTWithSub() throws ParseError {
		new Operation(GT.class).testRels(new Operation(Sub.class));
	}

	@Test
	public void testGTWithMul() throws ParseError {
		new Operation(GT.class).testRels(new Operation(Mul.class));
	}

	@Test
	public void testGTWithDiv() throws ParseError {
		new Operation(GT.class).testRels(new Operation(Div.class));
	}

	@Test
	public void testGEqWithAdd() throws ParseError {
		new Operation(GEq.class).testRels(new Operation(Add.class));
	}

	@Test
	public void testGEqWithSub() throws ParseError {
		new Operation(GEq.class).testRels(new Operation(Sub.class));
	}

	@Test
	public void testGEqWithMul() throws ParseError {
		new Operation(GEq.class).testRels(new Operation(Mul.class));
	}

	@Test
	public void testGEqWithDiv() throws ParseError {
		new Operation(GEq.class).testRels(new Operation(Div.class));
	}

	@Test
	public void testEqWithAdd() throws ParseError {
		new Operation(Eq.class).testRels(new Operation(Add.class));
	}

	@Test
	public void testEqWithSub() throws ParseError {
		new Operation(Eq.class).testRels(new Operation(Sub.class));
	}

	@Test
	public void testEqWithMul() throws ParseError {
		new Operation(Eq.class).testRels(new Operation(Mul.class));
	}

	@Test
	public void testEqWithDiv() throws ParseError {
		new Operation(Eq.class).testRels(new Operation(Div.class));
	}

	@Test
	public void testNEqWithAdd() throws ParseError {
		new Operation(NEq.class).testRels(new Operation(Add.class));
	}

	@Test
	public void testNEqWithSub() throws ParseError {
		new Operation(NEq.class).testRels(new Operation(Sub.class));
	}

	@Test
	public void testNEqWithMul() throws ParseError {
		new Operation(NEq.class).testRels(new Operation(Mul.class));
	}

	@Test
	public void testNEqWithDiv() throws ParseError {
		new Operation(NEq.class).testRels(new Operation(Div.class));
	}

}
