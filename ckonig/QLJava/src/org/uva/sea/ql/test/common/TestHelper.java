package org.uva.sea.ql.test.common;

import org.junit.Assert;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;

public abstract class TestHelper<T> {
	protected Class<?> asClass;
	protected String asString;
	protected TestParser parser;

	public TestHelper(TestParser parser) {
		this.parser = parser;
	}

	public abstract T setClass(Class<?> c);
	
	public void setClassAndString(Class<?> c) {
		this.asClass = c;
		if (c == Add.class) {
			this.asString = Add.STR;
		}
		if (c == Sub.class) {
			this.asString = Sub.STR;
		}
		if (c == Mul.class) {
			this.asString = Mul.STR;
		}
		if (c == Div.class) {
			this.asString = Div.STR;
		}
		if (c == Eq.class) {
			this.asString = Eq.STR;
		}
		if (c == NEq.class) {
			this.asString = NEq.STR;
		}
		if (c == LT.class) {
			this.asString = LT.STR;
		}
		if (c == LEq.class) {
			this.asString = LEq.STR;
		}
		if (c == GT.class) {
			this.asString = GT.STR;
		}
		if (c == GEq.class) {
			this.asString = GEq.STR;
		}
		if (c == Neg.class) {
			this.asString = Neg.STR;
		}
		if (c == Not.class) {
			this.asString = Not.STR;
		}
		if (c == And.class) {
			this.asString = And.STR;
		}
		if (c == Or.class) {
			this.asString = Or.STR;
		}
		if (this.asString == null) {
			throw new RuntimeException("class not recognized");
		}
	}

	protected void testBinary(Class<?> c, String in, Class<?> left,
			Class<?> right) throws ParseError {
		Expr e = parser.parse(in);
		Assert.assertNotNull("result was null", e);
		Assert.assertEquals(c, e.getClass());
		BinaryExpr b = (BinaryExpr) e;
		Expr leftChild = b.getLeft();
		Assert.assertNotNull("left child of binary expr was null", leftChild);
		Assert.assertEquals(left, leftChild.getClass());
		Expr rightChild = b.getRight();
		Assert.assertNotNull("right child of binary expr was null", rightChild);
		Assert.assertEquals(right, rightChild.getClass());
	}

}
