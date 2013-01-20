package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.ArithmeticExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Pos extends ArithmeticExpr {

	public Pos(Expr lhs) {
		super(lhs, null);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
