package org.uva.sea.ql.core.dom.types.declarations;

import org.uva.sea.ql.core.dom.ASTNode;
//import org.uva.sea.ql.core.dom.ExpressionVisitor;

public abstract class TypeDeclaration extends ASTNode{
	
	private String typeName;

	public TypeDeclaration(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	//public abstract void accept(ExpressionVisitor expressionVisitor) ;
}
