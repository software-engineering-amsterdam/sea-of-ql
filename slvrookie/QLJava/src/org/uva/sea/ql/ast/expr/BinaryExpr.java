package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class BinaryExpr extends Expr {

	private final Expr lhs;
	private final Expr rhs;

	protected BinaryExpr(Expr lhs, Expr rhs) {
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
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
	}	
	
}
