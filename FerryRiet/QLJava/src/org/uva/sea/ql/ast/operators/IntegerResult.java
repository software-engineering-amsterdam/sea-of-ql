package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.types.TypeDescription;
import org.uva.sea.ql.ast.types.NumeralType;


public class IntegerResult implements ExpressionResult {
	private Integer value;

	public IntegerResult(int val) {
		value = new Integer(val);
	}

	public int getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	@Override
	public TypeDescription typeOf() {
		return new NumeralType() ;
	}
}
