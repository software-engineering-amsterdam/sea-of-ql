package org.uva.sea.ql.interpreter;

public class BoolType extends Value{
	
	private final boolean bool;
	
	public BoolType(boolean bool){
		this.bool = bool;
	}

	public boolean getBool() {
		return bool;
	}
}
