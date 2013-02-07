package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTVisitor;

public abstract class QLProgram implements ASTNode {
	
	public abstract boolean accept(ASTVisitor visitor);

}
