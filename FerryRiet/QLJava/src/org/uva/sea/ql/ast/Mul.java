package org.uva.sea.ql.ast;

public class Mul extends Expr {

	public Mul(Expr result, Expr rhs) {
		super(result,rhs) ;
	}
	public void eval() {

		exLeftHand.eval();

		System.out.print(" < ");

		exRightHand.eval();

	}
}
