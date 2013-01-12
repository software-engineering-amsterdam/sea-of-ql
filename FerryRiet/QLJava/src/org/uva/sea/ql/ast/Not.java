package org.uva.sea.ql.ast;

public class Not extends UnExpr {

	public Not(Expr x) {
		super(x);
	}

	public void eval() {

		System.out.print(" ! ");

		exRightHand.eval();

	}
}
