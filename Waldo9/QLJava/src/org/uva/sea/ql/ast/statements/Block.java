package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.ASTNodeVisitor;


public class Block extends Statement {
	
	private final List<Statement> statements;
	
	public Block(List<Statement> statements) {
		this.statements = statements;
	}
	
	public List<Statement> getStatements() {
		return statements;
	}
	
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		return visitor.visit(this);
    }

}
