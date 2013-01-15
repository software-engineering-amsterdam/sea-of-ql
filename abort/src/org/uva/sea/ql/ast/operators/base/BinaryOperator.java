package org.uva.sea.ql.ast.operators.base;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public abstract class BinaryOperator extends Operator {
	protected final Node leftHandSide;
	protected final Node rightHandSide;
	
	protected BinaryOperator(final Node leftHandSide, final Node rightHandSide) {
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}
	
	public Node getLeftHandSide() {
		return leftHandSide;
	}
	
	public Node getRightHandSide() {
		return rightHandSide;
	}
	
	// Override in subclasses for stronger typing
	@Override
	public void accept(final IVisitor visitor) {
		leftHandSide.accept(visitor);
		rightHandSide.accept(visitor);
	}
}
