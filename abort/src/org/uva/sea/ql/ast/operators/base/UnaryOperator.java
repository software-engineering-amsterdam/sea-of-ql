package org.uva.sea.ql.ast.operators.base;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Unary Operator base class for unary operators in the QL language.
 * @author J. Dijkstra
 */
public abstract class UnaryOperator extends Operator {
	/**
	 * The node or operation that the unary operator affects.
	 */
	protected final Node node;
	
	/**
	 * Constructor.
	 * @param node the node or operation that the unary operator affects.
	 */
	protected UnaryOperator(final Node node) {
		this.node = node;
	}
	
	/**
	 * Retrieve the node or operation the unary operator affects.
	 * @return node/operation
	 */
	public Node getNode() {
		return node;
	}
	
	// Override in subclasses for stronger typing
	@Override
	public void accept(final IVisitor visitor) {
		node.accept(visitor);
	}
}
