package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
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
		// TODO Auto-generated method stub
		return null;
	}
}
