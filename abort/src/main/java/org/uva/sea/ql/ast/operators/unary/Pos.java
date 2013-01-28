package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents the positive operation in the QL language.
 * @author J. Dijkstra
 */
public class Pos extends UnaryOperator {
	/**
	 * Constructor.
	 * @param expression expression or operation pos operation affects
	 */
	public Pos(final Expression expression) {
		super(expression);
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
