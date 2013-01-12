package org.uva.sea.ql.ast;

public class Or extends BinExpr {

	public Or(Expr result, Expr rhs) {
		super(result,rhs) ;
	}
	public void eval() {

		exLeftHand.eval();

		System.out.print(" or ");

		exRightHand.eval();

	}
}
