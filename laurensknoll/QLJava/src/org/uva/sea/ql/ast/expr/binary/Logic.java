package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class Logic extends AbstractBinary {

	public Logic(AbstractExpr leftHandSide, AbstractExpr rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
