package org.uva.sea.ql.ast;

public class And extends BinExpr {

	public And(Expr result, Expr rhs) {
		super(result, rhs);
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" and ");

		exRightHand.eval();

	}
}
