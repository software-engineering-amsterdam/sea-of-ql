package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class BinaryExpression extends Expr{
	private Expr lhs;
	private Expr rhs;
	
	public BinaryExpression (Expr lhs, Expr rhs){
		this.lhs=lhs;	
		this.rhs=rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}