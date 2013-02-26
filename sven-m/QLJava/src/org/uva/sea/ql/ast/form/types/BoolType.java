package org.uva.sea.ql.ast.form.types;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.TypeVisitor;

public class BoolType extends Type {
	
	public BoolType(Location location) {
		super(location);
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "boolean";
	}
	
}
