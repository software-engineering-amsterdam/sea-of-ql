package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public class NEq extends Expr{
	private Expr lhs;
	private Expr rhs;
	
	public NEq (Expr lhs, Expr rhs){
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
