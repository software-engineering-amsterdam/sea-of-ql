package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Str implements Value {

	private final String value;

	public Str(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

    public Bool isEqualTo(Str other) {
        return new Bool(getValue().equals(other.getValue()));
    }

    public Bool isNotEqualTo(Str other) {
        return isEqualTo(other).not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return getValue().equals(((Str)o).getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}