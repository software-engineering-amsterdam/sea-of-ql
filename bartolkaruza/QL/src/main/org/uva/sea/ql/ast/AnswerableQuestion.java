package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.type.Type;

public class AnswerableQuestion extends Question {

	private Type type;
	
	public AnswerableQuestion(String name, String label, Type type, int lineNumber) {
		super(name, label, lineNumber);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

}
