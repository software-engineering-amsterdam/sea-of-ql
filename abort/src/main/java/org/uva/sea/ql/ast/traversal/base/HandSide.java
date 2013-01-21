package org.uva.sea.ql.ast.traversal.base;

/**
 * Represents a hand hide used for error logging.
 * @author J. Dijkstra
 */
public enum HandSide {
	/**
	 * Represents the left hand side.
	 */
	LEFT("left"),
	/**
	 * Represents the right hand side.
	 */
	RIGHT("right"),
	/**
	 * Represents both hand sides.
	 */
	BOTH("both");

	/**
	 * Name to be displayed for the hand side.
	 */
	private final String name;

	/**
	 * Constructor.
	 * @param name name to be displayed for the hand side
	 */
	private HandSide(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
