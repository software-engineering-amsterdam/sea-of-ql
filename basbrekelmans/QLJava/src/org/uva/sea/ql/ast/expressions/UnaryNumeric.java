package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public abstract class UnaryNumeric extends Unary {

	public UnaryNumeric(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation, operand);
	}
	
	@Override
	protected boolean isValidType(QLType type) {
		return type.isNumber();
	}
}
