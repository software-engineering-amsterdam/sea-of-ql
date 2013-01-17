package org.uva.sea.ql.ast;

public class LT extends Expr{
	private Expr lhs;
	private Expr rhs;
	
	public LT (Expr lhs, Expr rhs){
		this.lhs=lhs;	
		this.rhs=rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

}
