package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * Comparison (<, <=, >=, >, !=, ==) expressions
 * inherit from this type.
 */
public abstract class Comparison extends Binary {

	public Comparison(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}
}
