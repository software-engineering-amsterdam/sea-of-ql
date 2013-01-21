package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Eq extends Binary {

	public Eq(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }

}
