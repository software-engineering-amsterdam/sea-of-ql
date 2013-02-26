package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.TypeVisitor;

public class BooleanType extends Type {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public boolean isCompatibleTo(Type typeDeclaration) {
		return typeDeclaration.isCompatibleToBoolean();
	}

	@Override
	public boolean isCompatibleToBoolean() {
		return true;
	}

	@Override
	public void accept(TypeVisitor visitor) {
		visitor.visit(this);
	}
}
