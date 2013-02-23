package org.uva.sea.ql.core.dom.types.declarations;

import org.uva.sea.ql.core.dom.TypeVisitor;

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
