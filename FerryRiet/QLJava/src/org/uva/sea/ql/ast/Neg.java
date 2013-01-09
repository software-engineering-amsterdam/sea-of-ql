package org.uva.sea.ql.ast;

public class Neg extends Expr {

	public Neg(Expr x) {
		super(null,x) ;
	}
	public void eval() {


		System.out.print(" - ");

		exRightHand.eval();

	}
}
