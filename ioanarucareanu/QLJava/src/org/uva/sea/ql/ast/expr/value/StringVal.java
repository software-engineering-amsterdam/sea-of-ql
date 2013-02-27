package org.uva.sea.ql.ast.expr.value;

public class StringVal extends Val {
	
	private String value;
	
	public StringVal() {
		value = "";
	}
	
	public StringVal(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}


}
