package org.uva.sea.ql.core.dom;

public abstract class Expression extends ASTNode {
	public abstract void accept(ExpressionVisitor visitor);	
}
