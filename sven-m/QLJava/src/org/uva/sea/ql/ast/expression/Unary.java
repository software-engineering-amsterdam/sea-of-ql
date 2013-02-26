package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;

public abstract class Unary extends Expr {
	private final Expr op;

	public Unary(Expr op) {
		this.op = op;
	}

	public Expr getOp() {
		return op;
	}

	public Location getLocation() {
		return op.getLocation();
	}
}
