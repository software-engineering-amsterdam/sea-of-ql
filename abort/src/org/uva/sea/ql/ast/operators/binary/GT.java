package org.uva.sea.ql.ast.operators.binary;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a greater than operation in the QL language.
 * @author J. Dijkstra
 */
public class GT extends BinaryOperator {
	/**
	 * Constructor.
	 * @param leftHandSide left hand side of the operator
	 * @param rightHandSide right hand side of the operator
	 */
	public GT(final Node leftHandSide, final Node rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
