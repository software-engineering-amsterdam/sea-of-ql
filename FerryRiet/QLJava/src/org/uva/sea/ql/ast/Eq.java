package org.uva.sea.ql.ast;

public class Eq extends BinExpr {

	public Eq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" == ");

		exRightHand.eval();

	}

}
