package org.uva.sea.ql.ast;

public class GEq extends BinExpr {

	public GEq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" >= ");

		exRightHand.eval();

	}
}
