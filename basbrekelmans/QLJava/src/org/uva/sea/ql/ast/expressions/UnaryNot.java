package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public class UnaryNot extends Unary {

	public UnaryNot(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation, operand);
	}

	@Override
	protected boolean isValidType(QLType type) {
		return type == QLType.BOOLEAN;
	}
}
