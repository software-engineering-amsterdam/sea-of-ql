package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Bool extends Leaf {

	private final boolean value;

	public Bool(boolean v, Location location) {
		super(location);
		this.value = v;
	}

	public boolean getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
