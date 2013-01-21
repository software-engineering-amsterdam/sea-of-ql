package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class AbstractBinary extends AbstractExpr {

	private final AbstractExpr lhsExpr;
	private final AbstractExpr rhsExpr;

	public AbstractBinary(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		this.lhsExpr = lhsExpr;
		this.rhsExpr = rhsExpr;
	}

	public AbstractExpr getLeftHandSideExpression() {
		return this.lhsExpr;
	}

	public AbstractExpr getRightHandSideExpression() {
		return this.rhsExpr;
	}

}
