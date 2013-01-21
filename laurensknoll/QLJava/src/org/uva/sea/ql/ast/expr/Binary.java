package org.uva.sea.ql.ast.expr;

public abstract class Binary extends AbstractExpr {

	private final AbstractExpr lhsExpr;
	private final AbstractExpr rhsExpr;

	public Binary(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
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
