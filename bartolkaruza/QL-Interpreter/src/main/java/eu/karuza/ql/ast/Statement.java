package eu.karuza.ql.ast;

import eu.karuza.ql.visitor.StatementVisitor;

public interface Statement extends ASTNode {
	
	public void accept(StatementVisitor<?> visitor);

}
