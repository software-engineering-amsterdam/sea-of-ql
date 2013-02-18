package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class Numeric extends AbstractBinary {

	public Numeric(AbstractExpr leftHandSide, AbstractExpr rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
