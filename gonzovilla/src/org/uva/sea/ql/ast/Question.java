package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;

public class Question extends FormUnit {

	private String name;
	private String body;
	private Type type;
	
	public Question(String name, String body, Type type) {
		this.name = name;
		this.body = body;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getBody() {
		return body;
	}

	public Type getType() {
		return type;
	}

}
