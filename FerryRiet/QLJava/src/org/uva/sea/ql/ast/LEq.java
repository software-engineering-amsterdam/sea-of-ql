package org.uva.sea.ql.ast;

public class LEq extends Expr {

	public LEq(Expr result, Expr rhs) {
		super(result,rhs) ;
	}

	public void eval() {

		exLeftHand.eval();

		System.out.print(" <= ");

		exRightHand.eval();

	}
}
