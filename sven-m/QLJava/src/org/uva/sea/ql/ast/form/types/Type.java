package org.uva.sea.ql.ast.form.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Location;

public abstract class Type implements ASTNode {
	private Location location;
	
	public Type(Location location) {
		this.location = location;
	}
	
	public boolean equals(Type type) {
		return this.getClass() == type.getClass();
	}
	
	@Override
	public Location getLocation() {
		return location;
	}
	
}
