package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class GEq extends Arithmetic {

	public GEq(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}

	@Override
	public <T> T accept(IExpression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractType typeOf(Environment environment) {
		return new Bool();
	}

	@Override
	public String toString() {
		return String.format("%s >= %s", this.getLeftHandSide().toString(),
				this.getRightHandSide().toString());
	}

}
