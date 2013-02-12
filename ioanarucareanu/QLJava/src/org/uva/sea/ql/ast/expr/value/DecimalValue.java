package org.uva.sea.ql.ast.expr.value;

public class DecimalValue extends Value<Float>{

	public DecimalValue() {
		super((float) 0);
	}
	
	public DecimalValue(Float value) {
		super(value);
	}

}
