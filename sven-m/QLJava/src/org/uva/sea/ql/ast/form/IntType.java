package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class IntType extends Type {

	public IntType(Location location) {
		super(location);
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
