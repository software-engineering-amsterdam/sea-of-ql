package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class IntegerType extends DataType {

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.NUMERIC;
	}

	@Override
	public String toString() {
		return "IntegerType [getNature()=" + getNature() + "]";
	}

}
