package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.Expression;

public class Mul extends AbstractBinary {

	public Mul(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}

	@Override
	public void accept(Expression<?> visitor) {
		visitor.visit(this);
	}

}
