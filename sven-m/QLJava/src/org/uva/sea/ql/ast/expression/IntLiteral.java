package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class IntLiteral extends Leaf {
	private final int value;

	public IntLiteral(int value, Location location) {
		super(location);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
