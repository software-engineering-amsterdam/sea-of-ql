package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public class UnaryPlus extends UnaryNumeric {

	public UnaryPlus(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation, operand);
	}
}
