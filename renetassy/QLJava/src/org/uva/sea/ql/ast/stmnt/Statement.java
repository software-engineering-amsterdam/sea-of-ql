package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.StatementChecker;

public abstract class Statement implements ASTNode {
	
	public abstract boolean accept(StatementChecker visitor);

}
