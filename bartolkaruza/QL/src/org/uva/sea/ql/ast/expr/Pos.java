package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Pos extends Expr {

	public Pos(Expr lhs) {
		super(lhs, null);
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
