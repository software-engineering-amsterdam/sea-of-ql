package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.DecimalValue;
import org.uva.sea.ql.ast.expr.value.Value;

public class DecimalType extends Type {

	@Override
	public Value<?> createValueOfType() {
		
		return new DecimalValue();
	}

	@Override
	public String toString() {
		
		return "decimal";
	}
	

}
