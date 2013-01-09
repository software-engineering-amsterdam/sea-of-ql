package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.NodeVisitor;

public abstract class Expr implements ASTNode {
	
	boolean value;

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
