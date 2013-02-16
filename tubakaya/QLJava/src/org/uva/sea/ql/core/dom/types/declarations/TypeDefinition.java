package org.uva.sea.ql.core.dom.types.declarations;

import org.uva.sea.ql.core.dom.ASTNode;

public abstract class TypeDefinition extends ASTNode{
	
	private String typeName;

	public TypeDefinition(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
}
