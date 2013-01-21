package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
	
}
