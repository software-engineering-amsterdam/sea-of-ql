package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.expr.value.StringValue;

public class StringType extends Type {

	@Override
	public Value<?> createValueOfType() {
		
		return new StringValue();
	}

	@Override
	public String getHumanReadableType() {
		
		return "text";
	}

}
