package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.BooleanExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Or extends BooleanExpr {

	public Or(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}