package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public class BooleanLiteral extends Literal {

	private final boolean value;
	public BooleanLiteral(ICodeLocationInformation codeLocation, boolean value) {
		super(codeLocation);
		this.value = value;
	}

	@Override
	public QLType getType() {
		return QLType.BOOLEAN;
	}

}
