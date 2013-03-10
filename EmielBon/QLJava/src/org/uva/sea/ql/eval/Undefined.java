package org.uva.sea.ql.eval;

public class Undefined extends Value {

	public static final Undefined UNDEF = new Undefined();
	
	private Undefined() {
		
	}
	
	public String toString() {
		return "";
	}
	
}
