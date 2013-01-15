package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public class LessThanOrEquals extends Comparison {

	public LessThanOrEquals(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}

}
