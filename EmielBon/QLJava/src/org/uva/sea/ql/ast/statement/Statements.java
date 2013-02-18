package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.typechecker.StatementVisitor;

public class Statements extends Statement {

	private final List<Statement> statements = new ArrayList<Statement>();
	
	public Statements(Statement statement) {
		statements.add(statement);
	}
	
	public Statements(Statement statement, Statements statements) {
		this.statements.add(statement);
		this.statements.addAll(statements.statements);
	}
	
	public List<Statement> getStatements() {
		return statements;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}