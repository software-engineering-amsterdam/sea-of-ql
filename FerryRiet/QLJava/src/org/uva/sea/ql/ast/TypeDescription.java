package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public abstract class TypeDescription implements ASTNode {
	private String typeName;

	public TypeDescription(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public abstract boolean compatibleType(TypeDescription testType) ;
}
