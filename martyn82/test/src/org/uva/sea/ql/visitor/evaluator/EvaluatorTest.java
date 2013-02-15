package org.uva.sea.ql.visitor.evaluator;

import org.uva.sea.ql.ast.expression.Expression;

abstract public class EvaluatorTest {
	protected final Environment environment;

	public EvaluatorTest( Environment environment ) {
		this.environment = environment;
	}

	protected Object eval( Expression expression ) {
		return Evaluator.evaluate( expression, this.environment ).getValue();
	}
}
