package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.ArithmeticExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Mul extends ArithmeticExpr {

	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}
