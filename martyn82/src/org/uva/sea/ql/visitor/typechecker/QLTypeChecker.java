package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.visitor.evaluator.Environment;

public class QLTypeChecker extends StatementChecker {
	public QLTypeChecker( Environment environment ) {
		super( environment, new ExpressionChecker( environment ) );
	}
}
