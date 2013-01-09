package org.uva.sea.ql.ast;

public class BooleanLiteral extends Expr {

	
	public BooleanLiteral(String string) {
		super(null,null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eval() {
		System.out.print("boolean");	
	}
}
