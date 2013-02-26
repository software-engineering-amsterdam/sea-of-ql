package org.uva.sea.ql.ast.types.declarations;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.TypeVisitor;

public abstract class TypeDeclaration extends ASTNode {

	private String typeName;

	public TypeDeclaration(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public abstract boolean isCompatibleTo(TypeDeclaration t);

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
