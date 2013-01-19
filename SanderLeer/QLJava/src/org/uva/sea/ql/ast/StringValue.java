package org.uva.sea.ql.ast;

public class StringValue implements ASTNode {
	private final String value;
	
	public StringValue(String value) {
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