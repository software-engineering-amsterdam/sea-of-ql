package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class AbstractBinary extends AbstractExpr {

	private final AbstractExpr leftHandSide;
	private final AbstractExpr rightHandSide;

	public AbstractBinary(AbstractExpr leftHandSide, AbstractExpr rightHandSide) {
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	public AbstractExpr getLeftHandSide() {
		return this.leftHandSide;
	}

	public AbstractExpr getRightHandSide() {
		return this.rightHandSide;
	}

}
