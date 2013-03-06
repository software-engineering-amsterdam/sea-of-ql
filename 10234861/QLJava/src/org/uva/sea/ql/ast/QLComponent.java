package org.uva.sea.ql.ast;

public abstract class QLComponent implements ASTNode {
	
	public abstract <T> T accept(IStatementVisitor<T> visitor);

}
