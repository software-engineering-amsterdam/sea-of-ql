package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class UnaryNumeric extends Unary {

	public UnaryNumeric(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation, operand);
	}
}
