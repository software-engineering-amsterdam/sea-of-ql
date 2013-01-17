package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Neg extends Expr {

	public Neg(Expr lhs) {
		super(lhs, null);
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
