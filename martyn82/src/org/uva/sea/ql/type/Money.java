package org.uva.sea.ql.type;

public class Money extends Number {
	private final int value;
	
	public Money( int value ) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
