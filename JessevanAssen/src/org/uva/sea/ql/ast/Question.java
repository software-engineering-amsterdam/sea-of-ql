package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Question implements Statement {

	private final String question;
	private final Ident identifier;
    private final Type type;
	
	public Question(String question, Ident identifier, Type type) {
		this.question = question;
		this.identifier = identifier;
        this.type = type;
	}
	
	public String getQuestion() { return question; }
    public Ident getIdentifier() { return identifier; }
    public Type getType() { return type; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
