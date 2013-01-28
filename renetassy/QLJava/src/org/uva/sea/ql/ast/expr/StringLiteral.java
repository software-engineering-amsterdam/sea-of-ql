package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTVisitor;


public class StringLiteral extends Expr {
	
	private final String value;
	
	public StringLiteral(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
