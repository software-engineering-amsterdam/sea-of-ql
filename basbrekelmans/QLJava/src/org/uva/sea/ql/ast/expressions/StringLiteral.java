package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public class StringLiteral extends Literal {

	private final String value;
	
	public StringLiteral(ICodeLocationInformation codeLocation, String value) {
		super(codeLocation);
		this.value = value;
	}

	@Override
	public QLType getType() {
		return QLType.STRING;
	}
	
	public String getValue()
	{
		return value;
	}
}
