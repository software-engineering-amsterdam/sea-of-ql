package org.uva.sea.ql.ast;

public class IntegerValue implements ASTNode {
	private final int value;

	public IntegerValue(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
