package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Mul extends BinaryTree {

	public Mul(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	public void accept(ASTNodeVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
    }

}
