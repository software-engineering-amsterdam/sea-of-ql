package org.uva.sea.ql.ast;

public class StringLiteral implements ASTNode {
	private final String strLtr;

	public StringLiteral(String strLtr) {
		this.strLtr = strLtr;
	}
	
	public String getStrLtr() {
		return strLtr;
	}
}