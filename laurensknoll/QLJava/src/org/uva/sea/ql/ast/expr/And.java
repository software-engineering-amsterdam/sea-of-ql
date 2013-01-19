package org.uva.sea.ql.ast.expr;

public class And extends Binary {

	public And(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}
}
