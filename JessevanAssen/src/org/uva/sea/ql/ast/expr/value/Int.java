package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Int implements Value {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
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
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
