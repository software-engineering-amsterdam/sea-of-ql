package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * Unary expression has one operand. Implemented by unary minus (-), unary plus
 * (+) and unary not (!).
 */
public abstract class Unary extends Expression {

	private final Expression operand;

	Unary(final ICodeLocationInformation codeLocation, final Expression operand) {
		super(codeLocation);
		this.operand = operand;
	}

	public Expression getOperand() {
		return this.operand;
	}
}
