package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class NumberLiteral extends Literal {

	NumberLiteral(final ICodeLocationInformation codeLocation) {
		super(codeLocation);
	}
}
