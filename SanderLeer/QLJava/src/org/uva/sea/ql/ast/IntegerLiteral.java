package org.uva.sea.ql.ast;

public class IntegerLiteral extends Literals {
	private final int value;

	public IntegerLiteral(int n) {
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
