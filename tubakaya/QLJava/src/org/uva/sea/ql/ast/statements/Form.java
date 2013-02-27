package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;

public class Form extends Statement {

	private List<Statement> statements;

	public Form(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public List<Statement> getStatements() {
		return statements;
	}
}
