package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public abstract class Statement implements ASTNode {
	public abstract void accept(IStatementVisitor visitor); 
}
