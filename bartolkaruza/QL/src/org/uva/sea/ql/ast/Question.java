package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Question implements Statement {

	private final String name;
	private final String label;
	private final int lineNumber;
	private Value value;
		
	public Question (String name, String label, int lineNumber) {
		this.name = name;
		this.label = label;
		this.lineNumber = lineNumber;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
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

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

}
