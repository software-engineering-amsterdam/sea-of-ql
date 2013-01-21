package org.uva.sea.ql.interpreter;

public class IntVal extends Value{
	
	private final int val;
	
	public IntVal(int val){
		this.val = val;
	}
	
	public Integer getVal(){
		return this.val;
	}
}
