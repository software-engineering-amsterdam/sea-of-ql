package org.uva.sea.ql.ast;

public class Int extends Value {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}

}