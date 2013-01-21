package org.uva.sea.ql.ast;

public class BooleanLiteral extends Literals {
	private final boolean value;
	
	public BooleanLiteral(boolean value) {
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
