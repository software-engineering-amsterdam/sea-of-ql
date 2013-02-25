package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * A logical expression is either an AND or an OR binary switch.
 */
public abstract class Logical extends Binary {

	Logical(final ICodeLocationInformation codeLocation, final Expression left,
			final Expression right) {
		super(codeLocation, left, right);
	}
}
