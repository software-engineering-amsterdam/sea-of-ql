package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public abstract class TypeDescription implements ASTNode {
	private String typeName ;
	
	public TypeDescription(String typeName) {
		this.typeName = typeName ;
	}
	public String getTypeName() {
		return typeName;
	}
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this) ;
	}
}
