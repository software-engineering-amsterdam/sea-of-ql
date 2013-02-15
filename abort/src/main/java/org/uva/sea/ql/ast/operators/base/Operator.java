package org.uva.sea.ql.ast.operators.base;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.base.SyntaxPosition;

/**
 * Operator base class for operators in the QL language.
 * 
 * @author J. Dijkstra
 */
public abstract class Operator extends Expression {
	/**
	 * Constructor.
	 * @param syntaxPosition position of the syntax in the original DSL input
	 */
	public Operator(final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
	}
}
