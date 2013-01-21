package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public class Add extends BinaryTree {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	public void accept(ASTNodeVisitor visitor) {
        super.accept(visitor);
		visitor.visit(this);
    }
	
}
