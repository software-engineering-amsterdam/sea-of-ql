package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public class UnaryMinus extends UnaryNumeric{

	public UnaryMinus(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation, operand);
	}
}
