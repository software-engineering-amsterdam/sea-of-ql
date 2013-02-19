package org.uva.sea.ql.ast;

import org.uva.sea.ql.IStatementVisitor;

public abstract class QLComponent implements ASTNode {
	
	public abstract <T> T accept(IStatementVisitor<T> visitor);

}
