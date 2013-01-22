package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public abstract class UnaryExpr extends Expr {

	private final Expr arg;

	protected UnaryExpr(Expr arg) {
		this.arg = arg;
	}

	public Expr getArg() {
		return arg;
	}

	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
	}
	
}
