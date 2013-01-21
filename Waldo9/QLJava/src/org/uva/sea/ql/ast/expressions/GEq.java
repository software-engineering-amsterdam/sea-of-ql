package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class GEq extends BinaryTree {

	public GEq(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	public void accept(ASTNodeVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
    }

}
