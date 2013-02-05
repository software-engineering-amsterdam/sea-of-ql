package org.uva.sea.ql.ast.stmnt;

import java.util.List;

import org.uva.sea.ql.StatementChecker;

public class Body extends Statement {
	
	private List<Statement> statements;
	
	public Body (List<Statement> statements) {
		this.statements=statements;
	}
	
	public List<Statement> getStatements() {
		return statements;
	}

	@Override
	public boolean accept(StatementChecker visitor) {
		return visitor.visit(this);
	}
	
}
