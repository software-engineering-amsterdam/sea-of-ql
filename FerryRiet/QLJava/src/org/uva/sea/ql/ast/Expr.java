package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public abstract class Expr implements ASTNode {
	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
