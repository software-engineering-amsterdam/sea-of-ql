package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents the negative operation in the QL language.
 * @author J. Dijkstra
 */
public class Neg extends UnaryOperator {
	/**
	 * Constructor.
	 * @param node node or operation the negative operation affects
	 */
	public Neg(final Node node) {
		super(node);
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
