package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Location;

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
