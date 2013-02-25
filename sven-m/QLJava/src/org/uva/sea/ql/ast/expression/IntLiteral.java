package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class IntLiteral extends Leaf {

	private final int value;

	public IntLiteral(int n, Location location) {
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
