package org.uva.sea.ql.ast.base;

/**
 * Represents a syntax position in the original QL input.
 * 
 * @author J. Dijkstra
 */
public class SyntaxPosition {
	/**
	 * Line number in the QL input.
	 */
	private final int lineNumber;
	/**
	 * Column number in the QL input.
	 */
	private final int columnNumber;

	/**
	 * Constructor.
	 * 
	 * @param lineNumber
	 *            line number in the QL input
	 * @param columnNumber
	 *            column number in the QL input
	 */
	public SyntaxPosition(final int lineNumber, final int columnNumber) {
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}

	/**
	 * Retrieve the line number.
	 * 
	 * @return line number
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Retrieve the column number.
	 * 
	 * @return column number
	 */
	public int getColumnNumber() {
		return columnNumber;
	}
}
