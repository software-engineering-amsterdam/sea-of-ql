package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public abstract class BinaryExpression extends Expr{
	private final Expr lhs;
	private final Expr rhs;
	
	protected BinaryExpression (Expr lhs, Expr rhs){
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