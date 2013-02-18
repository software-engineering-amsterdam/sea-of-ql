package org.uva.sea.ql.evaluator;

import java.util.Map;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.evaluator.environment.Bindable;

abstract public class Exporter {
	private final String name;
	private final Map<IdentifierExpression, Bindable> bindings;

	public Exporter( String formName, Map<IdentifierExpression, Bindable> bindings ) {
		this.name = formName;
		this.bindings = bindings;
	}

	protected String getName() {
		return this.name;
	}

	protected Map<IdentifierExpression, Bindable> getBindings() {
		return this.bindings;
	}

	abstract public void export( String fileName );
}
