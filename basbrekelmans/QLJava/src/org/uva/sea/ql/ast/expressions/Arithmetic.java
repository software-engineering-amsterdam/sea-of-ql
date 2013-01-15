package org.uva.sea.ql.ast.expressions;
import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public abstract class Arithmetic extends Binary {

	public Arithmetic(ICodeLocationInformation codeLocation, Expression left, Expression right) {
		super(codeLocation, left, right);
	}
	
	/* This implementation checks the left and right type of 
	 * the arithmetic expression. Both types should be a number
	 * and money has the precedence if both integer and money type
	 * are provided.
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
