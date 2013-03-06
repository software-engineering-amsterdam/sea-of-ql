package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;

public abstract class Expression extends ASTNode {
	
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
	public abstract Type accept(ExpressionTypeVisitor visitor);	
}
