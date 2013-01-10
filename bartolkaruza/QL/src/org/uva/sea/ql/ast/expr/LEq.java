package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.NodeVisitor;

public class LEq extends Expr {

	public LEq(Expr result, Expr rhs) {

	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
