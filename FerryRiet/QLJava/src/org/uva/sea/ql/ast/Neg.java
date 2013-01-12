package org.uva.sea.ql.ast;

public class Neg extends UnExpr {

	public Neg(Expr x) {
		super(x) ;
	}
	public void eval() {

		System.out.print(" - ");

		exRightHand.eval();

	}
}
