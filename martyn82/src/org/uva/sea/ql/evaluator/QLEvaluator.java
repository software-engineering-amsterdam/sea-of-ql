package org.uva.sea.ql.evaluator;

/**
 * Evaluator for QL.
 */
public class QLEvaluator extends StatementEvaluator {
	/**
	 * Constructs a new QLEvaluator.
	 *
	 * @param environment
	 */
	public QLEvaluator( Environment environment ) {
		super( environment, new ExpressionEvaluator( environment ), new TypeEvaluator() );
	}
}
