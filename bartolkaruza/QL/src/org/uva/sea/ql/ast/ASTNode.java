package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.NodeVisitor;

public interface ASTNode {
	
	public void walkChild(ASTNode parent);

	public void accept(NodeVisitor visitor);
}
