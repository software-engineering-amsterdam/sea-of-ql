package org.uva.sea.ql.ast;

import org.uva.sea.ql.StatementVisitor;

public abstract class QLProgram implements ASTNode {
	
	public abstract boolean accept(StatementVisitor visitor);

}
