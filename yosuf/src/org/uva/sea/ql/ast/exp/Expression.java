package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * 
 * 
 * @param <T>
 *            literal value which the expression returns
 */
public abstract class Expression<T> implements ASTNode, Natural {

	protected Expression() {
		super();
	}

	public abstract T accept(ExpressionVisitor visitor);
}
