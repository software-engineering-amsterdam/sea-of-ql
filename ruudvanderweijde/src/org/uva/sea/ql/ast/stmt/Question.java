package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.type.Type;


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
