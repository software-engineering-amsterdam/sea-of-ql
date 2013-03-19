package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;

public abstract class Statement implements ASTNode {

	public abstract void accept(StatementVisitor visitor);
	
}
