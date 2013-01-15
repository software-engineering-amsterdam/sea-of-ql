package org.uva.sea.ql.ast.operators.binary;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class GT extends BinaryOperator {

	public GT(final Node leftHandSide, final Node rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public void accept(IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
