package org.uva.sea.ql.ast.expr.value;

public class StringValue extends Value<String>{

	public StringValue() {
		super("");
	}
	
	public StringValue(String value) {
		super(value);
	}

}
