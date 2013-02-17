package org.uva.sea.ql.interpreter;

public class IntVal extends Value{
	
	private final int val;
	
	public IntVal(int val) {
		this.val = val;
	}
	
	public Integer getValue() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return Integer.toString(val);
	}

}
