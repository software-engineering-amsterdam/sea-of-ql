package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.TypeVisitor;

public abstract class Type extends ASTNode {

	private String typeName;

	public Type(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToInteger() {
		return false;
	}

	public boolean isCompatibleToBoolean() {
		return false;
	}

	public boolean isCompatibleToString() {
		return false;
	}

	public abstract void accept(TypeVisitor visitor);
}
