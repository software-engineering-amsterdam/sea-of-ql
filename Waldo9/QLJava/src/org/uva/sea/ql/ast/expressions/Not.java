package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Not extends Binary {

	public Not(Expr x) {
		super(x);
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }

}
