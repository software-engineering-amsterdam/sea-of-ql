package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.eval.Environment;

/**
 * Represents a TypeChecker.
 */
public class TypeChecker extends StatementChecker {
	/**
	 * Constructs a new TypeChecker instance.
	 *
	 * @param environment
	 */
	public TypeChecker( Environment environment ) {
		super( environment, new ExpressionChecker( environment ) );
	}
}
