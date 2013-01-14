package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public abstract class Comparison extends Binary {

	public Comparison(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}

	@Override
	public QLType getType() {
		QLType leftType = getLeft().getType();
		QLType rightType = getRight().getType();
		if (leftType == rightType) {
			return leftType;
		} else if (leftType.isNumber() && rightType.isNumber()) {
			return QLType.MONEY;
		} else {
			return QLType.UNKNOWN;
		}
	}

}
