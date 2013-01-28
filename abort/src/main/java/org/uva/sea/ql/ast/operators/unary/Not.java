package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents the not operation in the QL language.
 * @author J. Dijkstra
 */
public class Not extends UnaryOperator {
	/**
	 * Constructor.
	 * @param expression expression or operation the not operation affects
	 */
	public Not(final Expression expression) {
		super(expression);
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
