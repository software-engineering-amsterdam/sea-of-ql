package org.uva.sea.ql.ast;

public class Pos extends Expr {

	public Pos(Expr x) {
		super(null,x) ;
	}
	public void eval() {

		System.out.print(" + ");

		exRightHand.eval();

	}
}
