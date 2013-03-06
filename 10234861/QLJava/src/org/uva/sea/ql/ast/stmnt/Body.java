package org.uva.sea.ql.ast.stmnt;

import java.util.List;

import org.uva.sea.ql.ast.IStatementVisitor;

public class Body extends Statement {

	private List<Statement> statements;

	public Body(List<Statement> statements) {
		this.statements = statements;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
