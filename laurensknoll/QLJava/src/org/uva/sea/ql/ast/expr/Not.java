package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Not extends Unary {

	public Not(AbstractExpr expr) {
		super(expr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
