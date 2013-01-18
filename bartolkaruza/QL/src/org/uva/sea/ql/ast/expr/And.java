package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.NodeVisitor;

public class And extends Expr {

	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}


}
