package org.uva.sea.ql.runtime;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.runtime.values.Value;

public class ComputedRuntimeValue extends RuntimeValue implements Observer {

	private final IExpressionEvaluator eval;
	private final Expression expr;

	public ComputedRuntimeValue(final IExpressionEvaluator eval,
			final Expression expr) {
		this.eval = eval;
		this.expr = expr;
	}

	@Override
	public boolean isComputed() {
		return true;
	}

	@Override
	public void update(final Observable o, final Object arg) {
		final Value value = this.eval.eval(this.expr);
		this.setValue(value);
	}
}
