package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class MoneyLiteral extends NumberLiteral {
	private final double value;

	public MoneyLiteral( double value ) {
		this.value = value;
	}

	public double getValue() {
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
