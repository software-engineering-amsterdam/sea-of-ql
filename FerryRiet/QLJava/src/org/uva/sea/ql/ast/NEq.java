package org.uva.sea.ql.ast;

public class NEq extends Expr {

	public NEq(Expr result, Expr rhs) {
		super(result,rhs) ;
	}
	public void eval() {

		exLeftHand.eval();

		System.out.print(" < ");

		exRightHand.eval();

	}
}
