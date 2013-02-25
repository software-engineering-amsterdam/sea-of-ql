package org.uva.sea.ql.runtime;

import java.util.HashMap;
import java.util.Iterator;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.Statement;

public class Variables implements Iterable<Variable> {

	private final HashMap<Statement, Variable> variablesByStatement = new HashMap<Statement, Variable>();
	private final HashMap<Variable, Statement> statementsByVariable = new HashMap<Variable, Statement>();
	private final HashMap<Identifier, Statement> statementsByIdentifier = new HashMap<Identifier, Statement>();

	public void add(final Statement statement, final Variable variable) {
		this.variablesByStatement.put(statement, variable);
		this.statementsByVariable.put(variable, statement);
	}

	public void add(final Statement statement, final Variable variable,
			final Identifier identifier) {
		this.add(statement, variable);
		this.statementsByIdentifier.put(identifier, statement);
	}

	public boolean containsIdentifier(final Identifier identifier) {
		return this.statementsByIdentifier.containsKey(identifier);
	}

	public Variable get(final Identifier identifier) {
		return this.variablesByStatement.get(this.statementsByIdentifier
				.get(identifier));
	}

	public Variable get(final Statement statement) {
		return this.variablesByStatement.get(statement);
	}

	public Iterable<Identifier> getIdentifiers() {
		return this.statementsByIdentifier.keySet();
	}

	public Statement getStatement(final Identifier identifier) {
		return this.statementsByIdentifier.get(identifier);
	}

	public Statement getStatement(final Variable variable) {
		return this.statementsByVariable.get(variable);
	}

	@Override
	public Iterator<Variable> iterator() {
		return this.variablesByStatement.values().iterator();
	}

}
