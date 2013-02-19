package org.uva.sea.ql.exporter;

import java.util.Map;

import org.uva.sea.ql.evaluator.environment.Binding;

abstract public class Exporter {
	private final String name;
	private final Map<String, Binding> bindings;

	public Exporter( String formName, Map<String, Binding> bindings ) {
		this.name = formName;
		this.bindings = bindings;
	}

	protected String getName() {
		return this.name;
	}

	protected Map<String, Binding> getBindings() {
		return this.bindings;
	}

	abstract public void export( String fileName );
}
