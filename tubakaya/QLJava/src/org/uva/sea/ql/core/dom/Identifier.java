package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.types.declarations.NonDeclaredType;
import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public class Identifier extends Expression {

	private final String name;
	private TypeDeclaration type;
	
	public Identifier(String name) {
		this.name=name;
		this.type = new NonDeclaredType();
	}
	
	public Identifier(String name, TypeDeclaration type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}

	public String getName() {
		return name;
	}

	@Override
	public TypeDeclaration getType() {
		return this.type;
	}

	public void setType(TypeDeclaration type) {
		this.type = type;
	}
}
