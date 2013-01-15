package org.uva.sea.ql.ast;

import java.util.List;

public class Form {

	private final Ident id;
	private List<Statement> statements;
	
	public Form(Ident id, List<Statement> statements) {
		this.id = id;
		this.setStatements(statements);
	}

	public Ident getId() {
		return id;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

}
