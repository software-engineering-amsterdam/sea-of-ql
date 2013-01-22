package org.uva.sea.ql.ast;

public class StringLiteral extends Expr {
	
	private String value;
	
	public StringLiteral(String value) {
		this.value=value;
	}

}
