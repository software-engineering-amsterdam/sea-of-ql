package org.uva.sea.ql.ast.misc;

public class Location {
	private int startLine;
	private int endLine;
	private int startColumn;
	private int endColumn;
	
	public Location(int startLine, int startColumn,  int endLine,
			int endColumn)
	{
		this.startLine = startLine;
		this.endLine = endLine;
		this.startColumn = startColumn;
		this.endColumn = endColumn;
	}
	
	public Location(Location startLocation, int endLine, int endColumn) {
		if (startLocation != null) {
			this.startLine = startLocation.startLine;
			this.startColumn = startLocation.startColumn;
		}
		
		this.endLine = endLine;
		this.endColumn = endColumn;
	}
	
	public Location(int startLine, int startColumn, Location endLocation) {
		this.startLine = startLine;
		this.startColumn = startColumn;
		
		if (endLocation != null) {
			this.startLine = endLocation.startLine;
			this.startColumn = endLocation.startColumn;
		}
	}
	
	public Location(Location startLocation, Location endLocation) {
		if (startLocation != null) {
			this.startLine = startLocation.getStartLine();
			this.startColumn = startLocation.getStartColumn();
		} else {
			this.startLine = -1;
			this.startColumn = -1;
		}
		
		if (endLocation != null) {
			this.endLine = startLocation.getEndLine();
			this.endColumn = startLocation.getEndColumn();
		} else {
			this.endLine = -1;
			this.endColumn = -1;
		}
	}

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public int getEndColumn() {
		return endColumn;
	}
	
}
