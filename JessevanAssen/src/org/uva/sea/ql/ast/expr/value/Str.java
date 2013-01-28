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

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}