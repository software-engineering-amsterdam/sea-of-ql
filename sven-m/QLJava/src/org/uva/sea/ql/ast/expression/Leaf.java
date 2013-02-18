package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Location;

public abstract class Leaf extends Expr {
	private Location location;
	
	public Leaf(Location location) {
		this.location = location;
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

}
