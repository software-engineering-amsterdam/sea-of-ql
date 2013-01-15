package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;

public abstract class Expr implements ASTNode {
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
