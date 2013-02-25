package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class GreaterThanOrEquals extends NumericComparison {

	public GreaterThanOrEquals(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}

	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
