package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.Visitor;

public class Str extends Expr {

	private final String value;

	public Str(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}