package org.uva.sea.ql.ast;

public abstract class BlockStatement extends Statement {
	protected final StatementList statements;

	protected BlockStatement(StatementList statements) {
		this.statements = statements;
	}
	
	public StatementList getStatements() {
		return statements;
	}
}
