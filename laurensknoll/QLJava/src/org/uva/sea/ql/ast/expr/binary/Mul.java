package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.visitor.Expression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class Mul extends AbstractBinary {

	public Mul(AbstractExpr lhsExpr, AbstractExpr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}

	@Override
	public <T> T accept(Expression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractType typeOf(Environment environment) {
		return new Numeric();
	}

	@Override
	public String toString() {
		return String.format("%s * %s", this.getLeftHandSide().toString(), this
				.getRightHandSide().toString());
	}

}
