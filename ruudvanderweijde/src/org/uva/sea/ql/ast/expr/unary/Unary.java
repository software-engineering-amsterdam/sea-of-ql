package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Unary extends Expr {

	private final Expr arg;
	
	public Unary(Expr expression) {
		this.arg = expression;
	}
	
	public Expr getArg() {
		return arg;
	}
	
	@Override
	public void accept(Visitor visitor) {
		getArg().accept(visitor);
		visitor.visit(this);
	}
}
