package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class StringLiteral extends LiteralExpression {
	private final String value;

	public StringLiteral( String value ) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
