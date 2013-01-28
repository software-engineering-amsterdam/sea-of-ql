package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class NumberLiteral extends Literal {

	public NumberLiteral(ICodeLocationInformation codeLocation) {
		super(codeLocation);
	}
}
