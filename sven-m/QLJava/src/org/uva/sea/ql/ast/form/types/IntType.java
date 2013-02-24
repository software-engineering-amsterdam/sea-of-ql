package org.uva.sea.ql.ast.form.types;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.TypeVisitor;

public class IntType extends Type {
	public IntType(Location location) {
		super(location);
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
