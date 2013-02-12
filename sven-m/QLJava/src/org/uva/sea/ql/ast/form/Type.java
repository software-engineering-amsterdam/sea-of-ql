package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public abstract class Type implements FormNode {
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
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		// TODO: check dit nog even: hoe werkt dit nou?
		return null;
	}
	
}
