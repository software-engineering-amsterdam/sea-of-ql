package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTVisitor;


public class BoolLiteral extends Expr {
	
	private final String value;
	
	public BoolLiteral(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

}
