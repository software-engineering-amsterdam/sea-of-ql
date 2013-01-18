package org.uva.sea.ql.ast;

import java.util.List;

public class Form {

	private final String id;
	private List<Statement> statements;
	
	public Form(String id, List<Statement> statements) {
		this.id = id;
		this.setStatements(statements);
	}

	public String getId() {
		return id;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

}
