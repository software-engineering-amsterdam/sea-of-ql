package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Pos extends Unary {

	public Pos(AbstractExpr expr) {
		super(expr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
