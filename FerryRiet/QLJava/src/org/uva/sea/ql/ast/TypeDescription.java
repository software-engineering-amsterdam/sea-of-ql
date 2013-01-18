package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;

public abstract class TypeDescription implements ASTNode {
	private String typeName ;
	
	public TypeDescription(String typeName) {
		this.typeName = typeName ;
	}
	public String getTypeName() {
		return typeName;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}
}
