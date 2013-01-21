package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Div extends Binary {

	public Div(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
