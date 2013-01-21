package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Neg extends AbstractUnaryExpr {

	public Neg(AbstractExpr expression) {
		super(expression);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
