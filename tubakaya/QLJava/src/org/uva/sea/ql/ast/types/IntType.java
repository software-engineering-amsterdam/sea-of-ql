package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.TypeVisitor;

public class IntType extends Type {

	public IntType() {
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
	public void accept(TypeVisitor visitor) {
		visitor.visit(this);
	}
}
