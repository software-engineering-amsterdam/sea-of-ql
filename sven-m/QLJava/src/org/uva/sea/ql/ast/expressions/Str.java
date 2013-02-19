package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Str extends Leaf {

	private final String value;

	public Str(String n, Location location) {
		super(location);
		this.value = n;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
