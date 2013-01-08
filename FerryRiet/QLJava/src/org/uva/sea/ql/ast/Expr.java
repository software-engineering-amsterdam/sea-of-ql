package org.uva.sea.ql.ast;

public abstract class Expr implements ASTNode {
	protected Expr exLeftHand;
	protected Expr exRightHand;
	
	public Expr(Expr result, Expr rhs) {
		exLeftHand = result;
		exRightHand = rhs ;
	}

	abstract void eval() ;
}
