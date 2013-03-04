package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.Visitor;

public abstract class UnaryExpr extends Expr {
	protected Expr expression;
	
	public UnaryExpr(Expr result) {
		expression = result;
	}
	
	public Expr getExpr() {
		return expression;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return this.getType() + expression;
	}
	
}
