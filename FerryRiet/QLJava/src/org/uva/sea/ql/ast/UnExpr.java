package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public abstract class UnExpr extends Expr {
	public Expr exRightHand;
	
	public UnExpr(Expr rhs) {
		exRightHand = rhs ;
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
