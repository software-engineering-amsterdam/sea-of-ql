package org.uva.sea.ql.ast;

import java.util.ArrayList;

public class Statements extends Node {

	public ArrayList<Statement> statements = new ArrayList<Statement>();
	
	public Statements(Statement statement) {
		statements.add(statement);
	}
	
	public Statements(Statement statement, Statements statements) {
		this.statements.add(statement);
		this.statements.addAll(statements.statements);
	}

}
