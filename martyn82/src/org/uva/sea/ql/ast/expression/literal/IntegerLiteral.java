package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class IntegerLiteral extends NumberLiteral {
	private final int value;

	public IntegerLiteral( int value ) {
		this.value = value;
	}

	public int getValue() {
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
