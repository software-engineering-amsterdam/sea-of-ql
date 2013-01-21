package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents the positive operation in the QL language.
 * @author J. Dijkstra
 */
public class Pos extends UnaryOperator {
	/**
	 * Constructor.
	 * @param node node or operation pos operation affects
	 */
	public Pos(final Node node) {
		super(node);
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
