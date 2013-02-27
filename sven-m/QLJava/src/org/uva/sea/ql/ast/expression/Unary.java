package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;

public abstract class Unary extends Expr {
	private final Expr op;
	private final Location startLocation;

	public Unary(Expr op, Location startLocation) {
		this.op = op;
		this.startLocation = startLocation;
	}

	public Expr getOp() {
		return op;
	}

	public Location getLocation() {
		return new Location(getStartLocation(), getOp().getLocation());
	}

	private Location getStartLocation() {
		return startLocation;
	}
}
