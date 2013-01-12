package org.uva.sea.ql.ast;

public class Div extends BinExpr {

	private Expr exLeftHand;
	private Expr exRightHand;
	
	public Div(Expr result, Expr rhs) {
		super(result,rhs) ;
	}
	public void eval() {
		
		exLeftHand.eval() ;
		
		System.out.print(" / ");

		exRightHand.eval() ;
		
	}
}
