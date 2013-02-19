package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;

abstract public class EvaluatorTest {
	protected final ValueEnvironment environment;

	public EvaluatorTest( ValueEnvironment environment ) {
		this.environment = environment;
	}

	protected Object eval( Expression expression ) {
		return ExpressionEvaluator.evaluate( expression, this.environment ).getValue();
	}
}
