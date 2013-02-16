package org.uva.sea.ql.ast.types;

public abstract class TypeDefinition extends Expr{
	
	private String typeName;

	public TypeDefinition(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
}
