package org.uva.sea.ql.ast;

public class Add extends Expr {
	Expr  exLeftHand, exRightHand ;
	public Add(Expr result, Expr rhs) {
		// TODO Auto-generated constructor stub
		exLeftHand = result ;
		exRightHand = rhs ;
	}
	public int eval(){
		return 1 ;
	}
}
