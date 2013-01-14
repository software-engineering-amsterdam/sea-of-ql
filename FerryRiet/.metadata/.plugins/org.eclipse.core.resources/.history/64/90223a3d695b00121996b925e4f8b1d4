package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public abstract class Expr implements ASTNode {
	protected Expr exLeftHand;
	protected Expr exRightHand;
	
	public Expr(Expr result, Expr rhs) {
		exLeftHand = result;
		exRightHand = rhs ;
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
