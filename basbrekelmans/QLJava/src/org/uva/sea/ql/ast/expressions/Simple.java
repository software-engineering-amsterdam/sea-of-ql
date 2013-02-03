package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * A simple expression is either an identifier or a 
 * literal.
 */
public abstract class Simple extends Expression {

	public Simple(ICodeLocationInformation codeLocation) {
		super(codeLocation);
	}
}
