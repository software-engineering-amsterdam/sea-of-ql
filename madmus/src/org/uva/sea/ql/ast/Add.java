package org.uva.sea.ql.ast;

public class Add extends Expr{
	
	private final Expr lhs, rhs;
	
	public Add(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	
}
