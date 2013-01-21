package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTNodeVisitor;

public abstract class Expr implements ASTNode {
	
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
    }

}
