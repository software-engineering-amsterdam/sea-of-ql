package org.uva.sea.ql.runtime;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.runtime.values.Value;

public class RuntimeEnvironment {

	private final Variables variables;
	private final IExpressionEvaluator evaluator;

	public RuntimeEnvironment(final Variables variables,
			final IExpressionEvaluator evaluator) {
		this.variables = variables;
		this.evaluator = evaluator;
		for (final Variable variable : variables) {
			// resolve computed value when dependency changes
			if (variable.isComputed()) {
				this.setValue(variable);
				variable.setValueSetter(new Observer() {

					@Override
					public void update(final Observable o, final Object arg) {
						RuntimeEnvironment.this.setValue(variable);
					}
				});
			}
		}
	}

	private void setValue(final Variable variable) {
		final Statement statement = this.variables.getStatement(variable);
		final Value value = this.evaluator.getValue(statement.getExpression());
		variable.setValue(value);
	}
}
