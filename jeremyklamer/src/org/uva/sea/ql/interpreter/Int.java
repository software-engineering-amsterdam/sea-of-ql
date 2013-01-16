package org.uva.sea.ql.interpreter;

public class Int extends Value{
	
	private final int val;
	
	public Int(int val){
		this.val = val;
	}
	
	public Integer getVal(){
		return this.val;
	}
}
