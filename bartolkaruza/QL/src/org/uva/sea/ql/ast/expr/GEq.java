package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.NodeVisitor;


public class GEq extends Expr {
	
	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}	

}
