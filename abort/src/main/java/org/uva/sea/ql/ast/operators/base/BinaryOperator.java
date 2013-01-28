package org.uva.sea.ql.ast.operators.base;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Binary Operator base for binary operators in the QL language.
 * @author J. Dijkstra
 */
public abstract class BinaryOperator extends Operator {
	/**
	 * Left hand side of the operator.
	 */
	private final Expression leftHandSide;
	/**
	 * Right hand side of the operator.
	 */
	private final Expression rightHandSide;
	
	/**
	 * Constructor.
	 * @param leftHandSide left hand side of the operator.
	 * @param rightHandSide right hand side of the operator.
	 */
	protected BinaryOperator(final Expression leftHandSide, final Expression rightHandSide) {
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}
	
	/**
	 * Retrieve left hand side of the operator.
	 * @return left hand side
	 */
	public Expression getLeftHandSide() {
		return leftHandSide;
	}
	
	/**
	 * Retrieve the right hand side of the operator.
	 * @return right hand side
	 */
	public Expression getRightHandSide() {
		return rightHandSide;
	}
	
	// Override in subclasses for stronger typing
	@Override
	public void accept(final IVisitor visitor) {
		leftHandSide.accept(visitor);
		rightHandSide.accept(visitor);
	}
}
