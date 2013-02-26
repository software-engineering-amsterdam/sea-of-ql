package org.uva.sea.ql.ast.types.declarations;

import org.uva.sea.ql.ast.TypeVisitor;

public class NonDeclaredType extends TypeDeclaration {

	public NonDeclaredType() {
		super("Non-declared type");
	}

	@Override
	public boolean isCompatibleTo(TypeDeclaration typeDeclaration) {
		return false;
	}

	@Override
	public void accept(TypeVisitor visitor) {
	}
}
