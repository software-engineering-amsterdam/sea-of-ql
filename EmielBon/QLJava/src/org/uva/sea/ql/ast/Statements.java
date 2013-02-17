package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Statements extends Statement {

	public List<Statement> statements = new ArrayList<Statement>();
	
	public Statements(Statement statement) {
		statements.add(statement);
	}
	
	public Statements(Statement statement, Statements statements) {
		this.statements.add(statement);
		this.statements.addAll(statements.statements);
	}
	
	public List<Statement> getBody() {
		return statements;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}