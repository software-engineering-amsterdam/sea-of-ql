package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public class IntegerLiteral extends NumberLiteral {

	private long value;
	
	public IntegerLiteral(ICodeLocationInformation codeLocation, long value) {
		super(codeLocation);
		this.value = value;
	}

	@Override
	public QLType getType() {
		return QLType.INTEGER;
	}

}
