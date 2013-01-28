package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

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

public class TestHelper {
	protected Class<?> asClass;
	protected String asString;
	public TestHelper(Class<?> c){
		this.asClass = c;
		if (c == Add.class) {
			this.asString = Add.str;
		}
		if (c == Sub.class) {
			this.asString = Sub.str;
		}
		if (c == Mul.class) {
			this.asString = Mul.str;
		}
		if (c == Div.class) {
			this.asString = Div.str;
		}
		if (c == Eq.class) {
			this.asString = Eq.str;
		}
		if (c == NEq.class) {
			this.asString = NEq.str;
		}
		if (c == LT.class) {
			this.asString = LT.str;
		}
		if (c == LEq.class) {
			this.asString = LEq.str;
		}
		if (c == GT.class) {
			this.asString = GT.str;
		}
		if (c == GEq.class) {
			this.asString = GEq.str;
		}
		if (c == Neg.class) {
			this.asString = Neg.str;
		}
		if (c == Not.class) {
			this.asString = Not.str;
		}
		if (c == And.class) {
			this.asString = And.str;
		}
		if (c == Or.class) {
			this.asString = Or.str;
		}
		if (this.asString == null) {
			throw new RuntimeException("class not recognized");
		}
	}
	protected void testBinary(Class<?> c, String in, Class<?> left,
			Class<?> right) throws ParseError {
		Expr e = CurrentTest.parse(in);
		Assert.assertNotNull("result was null", e);
		assertEquals(c, e.getClass());
		BinaryExpr b = (BinaryExpr) e;
		Expr leftChild = b.getLeft();
		Assert.assertNotNull("left child of binary expr was null", leftChild);
		assertEquals(left,leftChild.getClass());
		Expr rightChild = b.getRight();
		Assert.assertNotNull("right child of binary expr was null", rightChild);
		assertEquals(right, rightChild.getClass());
	}

}
