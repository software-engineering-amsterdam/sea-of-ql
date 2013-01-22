package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.ASTNodeVisitor;


public class Block extends Statement {
	
	private List<Statement> statements;
	
	public Block(List<Statement> statements) {
		this.statements = statements;
	}
	
	public void accept(ASTNodeVisitor visitor) {
        for (Statement statement : statements)
        	statement.accept(visitor);
		visitor.visit(this);
    }

}
