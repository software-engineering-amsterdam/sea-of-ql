package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.EqualityExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Eq extends EqualityExpr {

	public Eq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
