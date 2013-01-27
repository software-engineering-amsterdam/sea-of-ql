package org.uva.sea.ql.ast;

public class StringLiteral implements ASTNode {
	private final String value;

	public StringLiteral(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "StringLiteral [value=" + value + "]";
	}

}
