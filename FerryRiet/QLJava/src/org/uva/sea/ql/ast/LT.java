package org.uva.sea.ql.ast;

public class LT extends BinExpr {

	public LT(Expr result, Expr rhs) {
		super(result,rhs) ;
		// TODO Auto-generated constructor stub
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" < ");

		exRightHand.eval();

	}
}
