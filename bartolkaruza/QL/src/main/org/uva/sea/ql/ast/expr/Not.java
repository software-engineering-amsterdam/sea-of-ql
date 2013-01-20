package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.BooleanExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Not extends BooleanExpr {

	public Not(Expr lhs) {
		super(lhs, null);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}
