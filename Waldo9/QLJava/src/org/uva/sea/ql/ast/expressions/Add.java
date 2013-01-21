package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Add extends Binary {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        super.accept(visitor);
		return visitor.visit(this);
    }
	
}
