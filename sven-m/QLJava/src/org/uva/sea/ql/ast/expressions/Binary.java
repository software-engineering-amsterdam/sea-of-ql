package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Location;

public abstract class Binary extends Expr {
	private final Expr lhs;
	private final Expr rhs;

	public Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLhs() {
		return lhs;
	}

	public Expr getRhs() {
		return rhs;
	}
	
	public Location getLocation() {
		return new Location(lhs.getLocation(), rhs.getLocation());
	}

}
