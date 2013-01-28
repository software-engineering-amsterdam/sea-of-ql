package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.nodes.ASTNode;

public abstract class Expr implements ASTNode {
	public abstract boolean isBinaryNode();
	public abstract boolean isUnaryNode();
	public abstract boolean isMultiNode();
}
