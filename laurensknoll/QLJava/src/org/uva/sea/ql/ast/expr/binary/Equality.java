package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class Equality extends AbstractBinary {

	public Equality(AbstractExpr leftHandSide, AbstractExpr rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
