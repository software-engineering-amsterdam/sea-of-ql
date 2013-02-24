package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public class Variable{

	private final Identifier identifier;
	private final TypeDeclaration typeDeclaration;
	
	public Variable(Identifier identifier, TypeDeclaration typeDeclaration)	{
		this.identifier=identifier;
		this.typeDeclaration=typeDeclaration;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public TypeDeclaration getTypeDeclaration() {
		return typeDeclaration;
	}
}
