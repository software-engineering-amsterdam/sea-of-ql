package org.uva.sea.ql.ast;

public class Not extends Expr {

	public Not(Expr x) {
		super(null, x);
	}

	public void eval() {

		System.out.print(" ! ");

		exRightHand.eval();

	}
}
