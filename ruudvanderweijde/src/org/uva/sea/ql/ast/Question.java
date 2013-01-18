package org.uva.sea.ql.ast;


public class Question extends Statement {
	
	private final String id;
	private final String label;
	private final Type type;

	public Question(String id, String label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

}
