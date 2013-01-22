package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public class Xor extends Logical {

	public Xor(ICodeLocationInformation codeLocation, Expression left,
			Expression right) {
		super(codeLocation, left, right);
	}

}
