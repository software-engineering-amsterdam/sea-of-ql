package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class StrLiteral extends Leaf {
	private final String value;

	public StrLiteral(String n, Location location) {
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
