package org.uva.sea.ql.core.dom;

public class Identifier  extends Expression {

	private final String name;
	
	public Identifier(String name) {
		this.name=name;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}

	public String getName() {
		return name;
	}
}
