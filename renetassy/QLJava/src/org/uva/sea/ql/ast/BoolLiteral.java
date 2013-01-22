package org.uva.sea.ql.ast;

public class BoolLiteral extends Expr {
	
	private String value;
	
	public BoolLiteral(String value) {
		this.value=value;
	}

}
