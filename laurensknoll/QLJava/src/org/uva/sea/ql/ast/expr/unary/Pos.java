package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Pos extends AbstractUnaryExpr {

	public Pos(AbstractExpr expr) {
		super(expr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
