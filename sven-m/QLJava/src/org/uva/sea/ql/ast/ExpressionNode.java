package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public interface ExpressionNode extends ASTNode {
	
	public <T> T accept(ExpressionVisitor<T> visitor);

}
