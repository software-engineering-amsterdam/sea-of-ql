package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.Visitor;

public abstract class BinaryExpr extends Expr {
	protected Expr leftExpr;
	protected Expr rightExpr;
	
	public BinaryExpr(Expr lhs, Expr rhs){
		leftExpr = lhs;
		rightExpr = rhs;
	}
	
	public Expr getLeft(){
		return leftExpr;
	}
	
	public Expr getRight(){
		return rightExpr;
	}
	
	@Override
	public boolean isNumeric() {
		return leftExpr.isNumeric() && rightExpr.isNumeric();
	}
	
	@Override
	public boolean isBoolean() {
		return leftExpr.isBoolean() && rightExpr.isBoolean();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString(){
		return leftExpr + this.getType() + rightExpr;
	}

}
