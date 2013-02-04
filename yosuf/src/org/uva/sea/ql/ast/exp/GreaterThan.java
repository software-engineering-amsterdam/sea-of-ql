package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class GreaterThan extends Binary {

	public GreaterThan(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.BOOLEAN;
	}
}
