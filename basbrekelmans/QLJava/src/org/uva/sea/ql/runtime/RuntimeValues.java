package org.uva.sea.ql.runtime;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.Statement;

public class RuntimeValues {

	private final Map<Statement, RuntimeValue> valuesByStatement = new HashMap<Statement, RuntimeValue>();
	private final Map<Identifier, RuntimeValue> valuesByIdentifier = new HashMap<Identifier, RuntimeValue>();

	public void add(final Statement statement, final RuntimeValue variable) {
		this.valuesByStatement.put(statement, variable);
	}

	public void add(final Statement statement, final RuntimeValue variable,
			final Identifier identifier) {
		this.add(statement, variable);
		this.valuesByIdentifier.put(identifier, variable);
	}

	public boolean containsIdentifier(final Identifier identifier) {
		return this.valuesByIdentifier.containsKey(identifier);
	}

	public RuntimeValue get(final Identifier identifier) {
		return this.valuesByIdentifier.get(identifier);
	}

	public RuntimeValue get(final Statement statement) {
		return this.valuesByStatement.get(statement);
	}

	public Iterable<Identifier> getIdentifiers() {
		return this.valuesByIdentifier.keySet();
	}

}
