package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Or extends Binary {

	public Or(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
