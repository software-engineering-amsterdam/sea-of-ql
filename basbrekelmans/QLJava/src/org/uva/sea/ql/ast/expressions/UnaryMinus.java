package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class UnaryMinus extends UnaryNumeric {

	public UnaryMinus(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation, operand);
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
