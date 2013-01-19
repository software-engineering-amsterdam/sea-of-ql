package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public class GEq extends Expr{
	private Expr lhs;
	private Expr rhs;
	
	public GEq (Expr lhs, Expr rhs){
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
