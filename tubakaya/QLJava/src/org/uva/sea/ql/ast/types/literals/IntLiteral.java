package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.types.Type;

public class IntLiteral extends QLValue {

	public final Integer value;

	public IntLiteral(String string) {
		this.value = Integer.parseInt(string);
	}

	public IntLiteral(Integer value) {
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

	@Override
	public Integer getIntegerValue() {
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

		return value.equals(((IntLiteral) obj).value);
	}

	public QLValue add(QLValue rhs) {
		return new IntLiteral(rhs.getIntegerValue() + this.getIntegerValue());
	}

	public QLValue div(QLValue rhs) {
		return new IntLiteral(this.getIntegerValue() / rhs.getIntegerValue());
	}

	public QLValue mul(QLValue rhs) {
		return new IntLiteral(this.getIntegerValue() * rhs.getIntegerValue());
	}

	public QLValue sub(QLValue rhs) {
		return new IntLiteral(this.getIntegerValue() - rhs.getIntegerValue());
	}

	public QLValue lEq(QLValue rhs) {
		return new BooleanLiteral(
				this.getIntegerValue() <= rhs.getIntegerValue());
	}

	public QLValue gEq(QLValue rhs) {
		return new BooleanLiteral(
				this.getIntegerValue() >= rhs.getIntegerValue());
	}

	public QLValue gT(QLValue rhs) {
		return new BooleanLiteral(
				this.getIntegerValue() < rhs.getIntegerValue());
	}

	public QLValue lT(QLValue rhs) {
		return new BooleanLiteral(
				this.getIntegerValue() > rhs.getIntegerValue());
	}

	public QLValue pos() {
		return this;
	}

	public QLValue neg() {
		return new IntLiteral(-this.getIntegerValue());
	}
}
