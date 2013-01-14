package org.uva.sea.ql.ast.expressions;
import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public abstract class Arithmetic extends Binary {

	public Arithmetic(ICodeLocationInformation codeLocation, Expression left, Expression right) {
		super(codeLocation, left, right);
	}
	
	/* (non-Javadoc)
	 * @see org.uva.sea.ql.ast.expressions.Expression#getType()
	 */
	@Override
	public QLType getType() {
		QLType leftType = getLeft().getType();
		QLType rightType = getRight().getType();
		if (!leftType.isNumber() || !rightType.isNumber()) {
			return QLType.UNKNOWN;
		} else if (leftType == QLType.INTEGER && rightType == QLType.INTEGER) {
			return QLType.INTEGER;
		} else {
			return QLType.MONEY;
		}
	}
}
