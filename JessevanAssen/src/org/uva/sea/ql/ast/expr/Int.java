package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.Visitor;

public class Int extends Expr {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
