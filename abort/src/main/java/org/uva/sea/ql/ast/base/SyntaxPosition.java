package org.uva.sea.ql.ast.base;

public class SyntaxPosition {
	private final int lineNumber;
	private final int columnNumber;
	
	public SyntaxPosition(final int lineNumber, final int columnNumber) {
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	
	public int getColumnNumber() {
		return columnNumber;
	}
}
