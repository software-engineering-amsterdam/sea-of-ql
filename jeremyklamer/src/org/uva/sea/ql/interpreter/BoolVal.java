package org.uva.sea.ql.interpreter;

public class BoolVal extends Value{
	
	private final boolean bool;
	
	public BoolVal(boolean bool) {
		this.bool = bool;
	}
	
	//TODO In the OO document it said not to use get and set, ask how to not use getters here? 
	public boolean getValue() {
		return bool;
	}
	
	@Override 
	public String toString() {
		return Boolean.toString(bool);
	}
	
}
