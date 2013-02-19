package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Int extends Leaf {

	private final int value;

	public Int(int n, Location location) {
		super(location);
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
