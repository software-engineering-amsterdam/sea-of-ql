package org.uva.sea.ql.ast.expr.value;

public class DecimalVal extends Val {
	
	private float value;
	
	public DecimalVal() {
		
	}
	
	public DecimalVal(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DecimalVal [value=" + value + "]";
	}


}
