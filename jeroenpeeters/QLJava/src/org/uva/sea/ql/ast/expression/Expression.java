package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.ASTNode;

public abstract class Expression implements ASTNode {

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
}