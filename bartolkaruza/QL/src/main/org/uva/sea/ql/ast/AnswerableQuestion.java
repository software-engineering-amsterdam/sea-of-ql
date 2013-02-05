package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class AnswerableQuestion extends Question {

	private Type type;
	
	public AnswerableQuestion(String name, String label, Type type, int lineNumber) {
		super(name, label, lineNumber);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
		
	}

}
