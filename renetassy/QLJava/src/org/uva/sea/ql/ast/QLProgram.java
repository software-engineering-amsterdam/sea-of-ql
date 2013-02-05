package org.uva.sea.ql.ast;

import org.uva.sea.ql.StatementChecker;

public abstract class QLProgram implements ASTNode {
	
	public abstract boolean accept(StatementChecker visitor);

}
