package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class Arithmetic extends AbstractBinary {

	public Arithmetic(AbstractExpr leftHandSide, AbstractExpr rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
