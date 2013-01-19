package org.uva.sea.ql.ast.expr;

public class Or extends Binary {

	public Or(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}
}
