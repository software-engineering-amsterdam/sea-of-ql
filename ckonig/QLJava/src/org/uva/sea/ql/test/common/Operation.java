package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;

public class Operation {
	protected Class<?> asClass;
	protected String asString;

	public Operation() {

	}

	public Operation(Class<?> c) {
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

	public void testRels(Operation opposite) throws ParseError {
		testBinary(this.asClass, "a " + this.asString + " b", Ident.class,
				Ident.class);
		testBinary(this.asClass, "a " + this.asString + " b "
				+ opposite.asString + " c", Ident.class, opposite.asClass);
		testBinary(this.asClass, "a " + this.asString + " (b "
				+ opposite.asString + " c)", Ident.class, opposite.asClass);
		testBinary(this.asClass, "(a " + opposite.asString + " b) "
				+ this.asString + " c", opposite.asClass, Ident.class);
		testBinary(this.asClass, "(a " + this.asString + " b)", Ident.class,
				Ident.class);
		testBinary(this.asClass, "a " + opposite.asString + " b "
				+ this.asString + " c", opposite.asClass, Ident.class);
		testBinary(this.asClass, "a " + this.asString + " b "
				+ opposite.asString + " c", Ident.class, opposite.asClass);
	}

	public void testBools(Operation opposite) throws ParseError {
		testBinary(this.asClass, "(a " + opposite.asString + " b) "
				+ this.asString + " (b " + opposite.asString + " c)",
				opposite.asClass, opposite.asClass);
		testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
				+ " (b " + opposite.asString + " c)", this.asClass,
				opposite.asClass);
		testBinary(this.asClass, "(a " + opposite.asString + " b) "
				+ this.asString + " (b " + this.asString + " c)",
				opposite.asClass, this.asClass);
		testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
				+ " (b " + this.asString + " c)", this.asClass, this.asClass);
	}

	public void testComplexBools(Operation opposite) throws ParseError {
		String complex = "(" + "(a " + this.asString + " b)" + " "
				+ opposite.asString + "" + " ( b " + opposite.asString + " c)"
				+ " ) " + "" + this.asString + " " + "(" + "(a "
				+ opposite.asString + " c)" + " " + opposite.asString + " "
				+ "(b " + this.asString + " c)" + ") ";
		Expr e = CurrentTest.parse(complex);
		Assert.assertNotNull(e);
		assertEquals(this.asClass, e.getClass());
		BinaryExpr b = (BinaryExpr) e;
		BinaryExpr left = (BinaryExpr) b.getLeft();
		BinaryExpr right = (BinaryExpr) b.getRight();
		assertEquals(opposite.asClass, left.getClass());
		assertEquals(opposite.asClass, right.getClass());
		assertEquals(this.asClass, left.getLeft().getClass());
		assertEquals(opposite.asClass, left.getRight().getClass());
		assertEquals(opposite.asClass, right.getLeft().getClass());
		assertEquals(this.asClass, right.getRight().getClass());
		assertEquals(Ident.class, ((BinaryExpr) left.getLeft()).getLeft()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) left.getLeft()).getRight()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) left.getRight()).getLeft()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) left.getRight()).getRight()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) right.getLeft()).getLeft()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) right.getLeft()).getRight()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) right.getRight()).getLeft()
				.getClass());
		assertEquals(Ident.class, ((BinaryExpr) right.getRight()).getRight()
				.getClass());
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

	public void testUnary() throws ParseError {
		Expr e = CurrentTest.parse(this.asString + "b");
		Assert.assertNotNull(e);
		assertEquals(this.asClass , e.getClass()
				);
	}

}
