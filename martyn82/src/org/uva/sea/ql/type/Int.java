package org.uva.sea.ql.type;

public class Int extends Number {
	private final int value;
	
	public Int( int value ) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
