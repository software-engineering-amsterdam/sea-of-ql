package org.uva.sea.ql.ast;

public class Identifier implements ASTNode {
	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
