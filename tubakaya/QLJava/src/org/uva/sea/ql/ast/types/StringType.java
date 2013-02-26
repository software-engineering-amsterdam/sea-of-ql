package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.TypeVisitor;

public class StringType extends Type {

	public StringType() {
		super("string");
	}

	@Override
	public boolean isCompatibleTo(Type typeDeclaration) {
		return typeDeclaration.isCompatibleToString();
	}

	@Override
	public boolean isCompatibleToString() {
		return true;
	}

	@Override
	public void accept(TypeVisitor visitor) {
		visitor.visit(this);
	}
}
