package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ExpressionNode;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public abstract class Expr implements ExpressionNode {
	
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
}
