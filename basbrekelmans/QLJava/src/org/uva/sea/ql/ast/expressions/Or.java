package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public class Or extends Logical {

	public Or(ICodeLocationInformation codeLocation, Expression left,
			Expression right) {
		super(codeLocation, left, right);
	}

}
