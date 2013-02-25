package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class EqualityComparison extends Comparison {

	EqualityComparison(final ICodeLocationInformation codeLocation,
			final Expression left, final Expression right) {
		super(codeLocation, left, right);
	}

}
