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
	
	@Override
	public <ReturnType, ParameterType> 
		ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
	return visitor.visit(this, param);
	}
}