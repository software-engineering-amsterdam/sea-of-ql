package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;

public abstract class Expression extends ASTNode {
	
	public abstract void accept(ExpressionVisitor visitor);	
	
	public abstract Type getType();
}
