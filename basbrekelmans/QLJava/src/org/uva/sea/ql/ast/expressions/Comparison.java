package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * Comparison (<, <=, >=, >, !=, ==) expressions inherit from this type.
 */
public abstract class Comparison extends Binary {

	Comparison(final ICodeLocationInformation codeLocation,
			final Expression left, final Expression right) {
		super(codeLocation, left, right);
	}
}
