package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.Expression;

public class Not extends AbstractUnary {

	public Not(AbstractExpr expr) {
		super(expr);
	}

	@Override
	public <T> T accept(Expression<T> visitor) {
		return visitor.visit(this);
	}

}
