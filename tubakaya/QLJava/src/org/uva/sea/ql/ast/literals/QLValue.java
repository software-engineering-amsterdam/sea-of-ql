package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.Expression;

public abstract class QLValue extends Expression {
	
	public Integer getIntegerValue() {
		throw new UnsupportedOperationException();
	}

	public Boolean getBooleanValue() {
		throw new UnsupportedOperationException();
	}

	public String getStringValue() {
		throw new UnsupportedOperationException();
	}
	
	public QLValue pos() {
		throw new UnsupportedOperationException();
	}

	public QLValue neg() {
		throw new UnsupportedOperationException();
	}

	public QLValue add(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue div(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue mul(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue sub(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue not() {
		throw new UnsupportedOperationException();
	}

	public QLValue and(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue or(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue eql(QLValue rhs) {
		return new BooleanLiteral(this.equals(rhs));
	}

	public QLValue nEq(QLValue rhs) {
		return new BooleanLiteral(!this.equals(rhs));
	}

	public QLValue lEq(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue gEq(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue gT(QLValue rhs) {
		throw new UnsupportedOperationException();
	}

	public QLValue lT(QLValue rhs) {
		throw new UnsupportedOperationException();
	}
}
