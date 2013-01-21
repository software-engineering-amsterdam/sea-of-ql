package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.ASTNodeVisitor;


public class Block extends Statement {
	
	private List<Statement> statements;
	
	public Block(List<Statement> statements) {
		this.statements = statements;
	}
	
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        for (Statement statement : statements)
        	statement.accept(visitor);
		return visitor.visit(this);
    }

}
