package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public class Variable extends ASTNode{

	public Identifier identifier;
	public TypeDeclaration typeDeclaration;
	
	public Variable(Identifier identifier, TypeDeclaration typeDeclaration)	{
		this.identifier=identifier;
		this.typeDeclaration=typeDeclaration;
	}
}
