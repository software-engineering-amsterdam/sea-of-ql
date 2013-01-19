package org.uva.sea.ql.ast.operators.base;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public abstract class UnaryOperator extends Operator {
	protected final Node node;
	
	protected UnaryOperator(final Node node) {
		this.node = node;
	}
	
	public Node getNode() {
		return node;
	}
	
	// Override in subclasses for stronger typing
	@Override
	public void accept(final IVisitor visitor) {
		node.accept(visitor);
	}
}
