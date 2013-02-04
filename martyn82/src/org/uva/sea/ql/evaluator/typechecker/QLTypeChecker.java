package org.uva.sea.ql.evaluator.typechecker;

import org.uva.sea.ql.evaluator.Environment;

/**
 * TypeChecker for QL.
 */
public class QLTypeChecker extends StatementChecker {
	/**
	 * Constructs a new QLTypeChecker.
	 *
	 * @param environment
	 */
	public QLTypeChecker( Environment environment ) {
		super( environment, new ExpressionChecker( environment ) );
	}
}
