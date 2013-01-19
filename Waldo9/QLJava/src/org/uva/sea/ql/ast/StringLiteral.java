package org.uva.sea.ql.ast;

public class StringLiteral implements ASTNode {
	
	private String value;
	
	public StringLiteral(String value) {
		this.value = value;
	}

}
