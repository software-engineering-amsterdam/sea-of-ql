package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class Relational extends AbstractBinary {

	public Relational(AbstractExpr leftHandSide, AbstractExpr rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
