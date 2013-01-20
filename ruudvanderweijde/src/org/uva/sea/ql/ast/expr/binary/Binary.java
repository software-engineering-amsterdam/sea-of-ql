package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Binary extends Expr {

	private final Expr lhs;
	private final Expr rhs;
	
	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

	@Override
	public void accept(Visitor visitor) {
		getLhs().accept(visitor);
		getRhs().accept(visitor);
		visitor.visit(this);
	}
}
