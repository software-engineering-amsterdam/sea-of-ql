package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Bool implements Value {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

    public Bool isEqualTo(Bool other) {
        return new Bool(getValue() == other.getValue());
    }

    public Bool isNotEqualTo(Bool other) {
        return isEqualTo(other).not();
    }

    public Bool and(Bool other) {
        return new Bool(getValue() && other.getValue());
    }

    public Bool or(Bool other) {
        return new Bool(getValue() || other.getValue());
    }

    public Bool not() {
        return new Bool(!getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return getValue() == ((Bool)o).getValue();
    }

    @Override
    public int hashCode() {
        return value ? 1 : 0;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
