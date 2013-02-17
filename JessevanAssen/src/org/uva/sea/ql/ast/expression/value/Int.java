package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;

public class Int implements Value {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

    public Int add(Int other) {
        return new Int(getValue() + other.getValue());
    }

    public Int subtractWith(Int other) {
        return new Int(getValue() - other.getValue());
    }

    public Int multiply(Int other) {
        return new Int(getValue() * other.getValue());
    }

    public Int divideBy(Int other) {
        return new Int(getValue() / other.getValue());
    }

    public Int positive() {
        if(getValue() >= 0)
            return new Int(getValue());
        else
            return new Int(getValue() * -1);
    }

    public Int negative() {
        if(getValue() <= 0)
            return new Int(getValue());
        else
            return new Int(getValue() * -1);
    }

    public Bool isGreaterThan(Int other) {
        return new Bool(getValue() > other.getValue());
    }

    public Bool isLesserThan(Int other) {
        return new Bool(getValue() < other.getValue());
    }

    public Bool isGreaterThanOrEqualTo(Int other) {
        return isEqualTo(other)
                .or(isGreaterThan(other));
    }

    public Bool isLesserThanOrEqualTo(Int other) {
        return isEqualTo(other)
                .or(isLesserThan(other));
    }

    public Bool isEqualTo(Int other) {
        return new Bool(getValue() == other.getValue());
    }

    public Bool isNotEqualTo(Int other) {
        return isEqualTo(other).not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return getValue() == ((Int)o).getValue();
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
	public <ReturnType, ParameterType> ReturnType accept(ExpressionVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
