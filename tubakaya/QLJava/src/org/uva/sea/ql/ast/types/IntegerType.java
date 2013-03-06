package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.TypeVisitor;

public class IntegerType extends Type {

	public IntegerType() {
		super("int");
	}

	@Override
	public boolean isCompatibleTo(Type typeDeclaration) {
		return typeDeclaration.isCompatibleToInteger();
	}

	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
