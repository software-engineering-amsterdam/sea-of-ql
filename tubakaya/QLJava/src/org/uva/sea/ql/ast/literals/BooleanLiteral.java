package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class BooleanLiteral extends QLValue {

	private final Boolean value;

	public BooleanLiteral(String string) {
		this.value = Boolean.parseBoolean(string);
	}

	public BooleanLiteral(Boolean value) {
		this.value = value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public Boolean getBooleanValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return value.equals(((BooleanLiteral) obj).value);
	}

	public QLValue and(QLValue rhs) {
		return new BooleanLiteral(rhs.getBooleanValue()
				&& this.getBooleanValue());
	}

	public QLValue or(QLValue rhs) {
		return new BooleanLiteral(rhs.getBooleanValue()
				|| this.getBooleanValue());
	}

	public QLValue not() {
		return new BooleanLiteral(!this.value);
	}
}
