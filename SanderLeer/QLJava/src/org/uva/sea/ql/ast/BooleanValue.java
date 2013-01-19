package org.uva.sea.ql.ast;

public class BooleanValue implements ASTNode {
	private final boolean value;
	
	public BooleanValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
