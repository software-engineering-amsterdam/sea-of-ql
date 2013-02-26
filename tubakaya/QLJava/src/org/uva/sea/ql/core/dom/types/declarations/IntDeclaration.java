package org.uva.sea.ql.core.dom.types.declarations;

import org.uva.sea.ql.core.dom.TypeVisitor;

public class IntDeclaration extends TypeDeclaration {

	public IntDeclaration() {
		super("int");
	}

	@Override
	public boolean isCompatibleTo(TypeDeclaration typeDeclaration) {
		return typeDeclaration.isCompatibleToInteger();
	}

	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}

	@Override
	public void accept(TypeVisitor visitor) {
		visitor.visit(this);
	}
}
