package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Expr implements ASTNode {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
