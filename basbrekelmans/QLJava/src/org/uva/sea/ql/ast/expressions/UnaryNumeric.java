package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class UnaryNumeric extends Unary {

	UnaryNumeric(final ICodeLocationInformation codeLocation,
			final Expression operand) {
		super(codeLocation, operand);
	}
}
