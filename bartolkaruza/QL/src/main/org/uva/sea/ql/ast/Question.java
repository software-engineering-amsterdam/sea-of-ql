package org.uva.sea.ql.ast;


public abstract class Question implements Statement {

	private final String name;
	private final String label;
	private final int lineNumber;

	public Question(String name, String label, int lineNumber) {
		this.name = name;
		this.label = label;
		this.lineNumber = lineNumber;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	
}
