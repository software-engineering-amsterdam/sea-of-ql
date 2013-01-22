package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
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

	public abstract boolean isCompatibleTo(TypeDescription t);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToString() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}
}
