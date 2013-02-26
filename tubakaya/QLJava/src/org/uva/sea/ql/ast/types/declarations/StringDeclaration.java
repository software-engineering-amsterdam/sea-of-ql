package org.uva.sea.ql.ast.types.declarations;

import org.uva.sea.ql.ast.TypeVisitor;

public class StringDeclaration extends TypeDeclaration {

	public StringDeclaration() {
		super("string");
	}

	@Override
	public boolean isCompatibleTo(TypeDeclaration typeDeclaration) {
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
