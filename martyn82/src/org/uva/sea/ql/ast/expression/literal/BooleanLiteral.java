package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class BooleanLiteral extends LiteralExpression {
	private final boolean value;

	public BooleanLiteral( boolean value ) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf( this.value );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
