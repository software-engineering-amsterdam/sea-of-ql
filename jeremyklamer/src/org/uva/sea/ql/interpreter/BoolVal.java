package org.uva.sea.ql.interpreter;

public class BoolVal extends Value{
	
	private final boolean bool;
	
	public BoolVal(boolean bool){
		this.bool = bool;
	}

	public boolean getBool() {
		return bool;
	}
}
