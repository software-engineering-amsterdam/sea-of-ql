package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class GT extends Binary {

	public GT(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }

}
