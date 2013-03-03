package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.TypeVisitor;

public class NonDeclaredType extends Type {

	public NonDeclaredType() {
		super("Non-declared type");
	}

	@Override
	public boolean isCompatibleTo(Type typeDeclaration) {
		return false;
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return null;
	}
}
