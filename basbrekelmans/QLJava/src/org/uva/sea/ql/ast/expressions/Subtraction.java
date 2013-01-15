package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public class Subtraction extends Arithmetic {

	public Subtraction(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}

}
