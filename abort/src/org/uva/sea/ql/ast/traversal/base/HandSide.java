package org.uva.sea.ql.ast.traversal.base;

public enum HandSide {
	LEFT("left"),
	RIGHT("right"),
	BOTH("both");

	private final String name;
	
	private HandSide(final String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
