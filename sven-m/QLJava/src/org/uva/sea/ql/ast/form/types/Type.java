package org.uva.sea.ql.ast.form.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.TypeVisitor;

public abstract class Type implements ASTNode {
	private Location location;
	
	public Type(Location location) {
		this.location = location;
	}
	
	public boolean equals(Type type) {
		return getClass() == type.getClass();
	}
	
	@Override
	public Location getLocation() {
		return location;
	}
	
	public abstract <T> T accept(TypeVisitor<T> visitor);
	public abstract String toString();
	
}
