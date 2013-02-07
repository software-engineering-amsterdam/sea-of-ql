package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.visitor.evaluator.Environment;

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
