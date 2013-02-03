package org.uva.sea.ql.ast.expr;


public class BoolLiteral extends Expr {
	
	private String value;
	
	public BoolLiteral(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

}
