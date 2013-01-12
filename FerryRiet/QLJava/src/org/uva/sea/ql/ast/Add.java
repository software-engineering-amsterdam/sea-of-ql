package org.uva.sea.ql.ast;

public class Add extends BinExpr {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" + ");

		exRightHand.eval();

	}
}
