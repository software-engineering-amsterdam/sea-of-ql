package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;


/**
 * Unary expression has one operand. Implemented by 
 * unary minus (-), unary plus (+) and unary not (!).
 */
public abstract class Unary extends Expression {
	
	private final Expression operand;

	public Unary(ICodeLocationInformation codeLocation, Expression operand) {
		super(codeLocation);
		this.operand = operand;
	}
	
	/* (non-Javadoc)
	 * @see org.uva.sea.ql.ast.Expression#getType()
	 */
	@Override
	public QLType getType() {
		QLType operandType = operand.getType();
		if (isValidType(operandType)) {
			return operand.getType();
		} else {
			return QLType.UNKNOWN;
		}
	}
	
	/**
	 * @param type
	 * @return When overridden in a derived method, determines
	 * if a certain type is valid for this type of expression.
	 */
	protected abstract boolean isValidType(QLType type);
	
	public Expression getOperand() {
		return operand;
	}
}
