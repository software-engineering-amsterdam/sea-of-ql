package org.uva.sea.ql.ast;

public class BooleanLiteral extends Expr {
	public String value ;
	
	public BooleanLiteral(String string) {
		value = string ;
	}

	@Override
	public void eval() {
		System.out.print("boolean");	
	}
}
