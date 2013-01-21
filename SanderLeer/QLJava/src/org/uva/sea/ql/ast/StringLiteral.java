package org.uva.sea.ql.ast;

public class StringLiteral extends Literals {
	private final String value;
	
	public StringLiteral(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}