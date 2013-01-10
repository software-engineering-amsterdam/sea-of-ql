package org.uva.sea.ql.ast;

public class Eq extends Expr {

	public Eq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" == ");

		exRightHand.eval();

	}

}
