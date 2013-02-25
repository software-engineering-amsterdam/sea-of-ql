package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class BoolLiteral extends Leaf {
	private final boolean value;

	public BoolLiteral(boolean value, Location location) {
		super(location);
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
