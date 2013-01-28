package org.uva.sea.ql.ast.statements;

import java.util.List;


public class Block extends Statement {
	
	private final List<Statement> statements;
	
	public Block(List<Statement> statements) {
		this.statements = statements;
	}
	
	public List<Statement> getStatements() {
		return statements;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
    }

}
