package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class NumericComparison extends Comparison {

	NumericComparison(final ICodeLocationInformation codeLocation,
			final Expression left, final Expression right) {
		super(codeLocation, left, right);
	}

}
