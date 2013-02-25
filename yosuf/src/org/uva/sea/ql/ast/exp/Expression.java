package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * 
 * 
 * @param <T>
 *            literal value which the expression returns
 */
public abstract class Expression implements ASTNode, Natural {

	protected Expression() {
		super();
	}

	public abstract Value accept(ExpressionVisitor visitor);
}
