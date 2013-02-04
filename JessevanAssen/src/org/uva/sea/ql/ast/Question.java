package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Type;

public class Question implements Statement {

	private final String question;
	private final Identifier identifier;
    private final Type type;
	
	public Question(String question, Identifier identifier, Type type) {
		this.question = question;
		this.identifier = identifier;
        this.type = type;
	}
	
	public String getQuestion() { return question; }
    public Identifier getIdentifier() { return identifier; }
    public Type getType() { return type; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
