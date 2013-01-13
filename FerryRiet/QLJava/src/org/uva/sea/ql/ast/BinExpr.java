package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public abstract class BinExpr extends Expr {
	public Expr exLeftHand;
	public Expr exRightHand;
	
	public BinExpr(Expr result, Expr rhs) {
		exLeftHand = result;
		exRightHand = rhs ;
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
