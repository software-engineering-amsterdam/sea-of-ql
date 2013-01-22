package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.Expression;

public class Not extends AbstractUnary {

	public Not(AbstractExpr expr) {
		super(expr);
	}

	@Override
	public void accept(Expression<?> visitor) {
		visitor.visit(this);
	}

}
