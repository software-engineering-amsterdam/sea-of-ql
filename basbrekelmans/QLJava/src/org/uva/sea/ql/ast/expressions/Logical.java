package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public abstract class Logical extends Binary {

	public Logical(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}
	
	/* (non-Javadoc)
	 * @see org.uva.sea.ql.ast.BinaryExpression#getType()
	 */
	@Override
	public QLType getType() {
		QLType leftType = getLeft().getType();
		QLType rightType = getRight().getType();		
		if (leftType == QLType.BOOLEAN && rightType == QLType.BOOLEAN) {
			return QLType.BOOLEAN;
		} else {
			return QLType.UNKNOWN;
		}
	}	
}
