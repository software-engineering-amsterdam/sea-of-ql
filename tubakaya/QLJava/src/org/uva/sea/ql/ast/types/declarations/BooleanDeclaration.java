package org.uva.sea.ql.ast.types.declarations;

import org.uva.sea.ql.ast.TypeVisitor;

public class BooleanDeclaration extends TypeDeclaration {

	public BooleanDeclaration() {
		super("boolean");
	}

	@Override
	public boolean isCompatibleTo(TypeDeclaration typeDeclaration) {
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
