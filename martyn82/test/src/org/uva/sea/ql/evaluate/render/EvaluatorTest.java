package org.uva.sea.ql.evaluate.render;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.evaluate.render.RuntimeEnvironment;
import org.uva.sea.ql.evaluate.render.ExpressionEvaluator;

abstract public class EvaluatorTest {
	protected final RuntimeEnvironment environment;

	public EvaluatorTest( RuntimeEnvironment environment ) {
		this.environment = environment;
	}

	protected Object eval( Expression expression ) {
		return ExpressionEvaluator.evaluate( expression, this.environment ).getValue();
	}
}
