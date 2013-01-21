package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class LEq extends Binary {

	public LEq(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }

}
