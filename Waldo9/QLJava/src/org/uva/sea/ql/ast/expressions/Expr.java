package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTNodeVisitor;

public abstract class Expr implements ASTNode {
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
