package org.uva.sea.ql.ast;

public class ComputedQuestion extends Question {
	
	private Expr expression;
	
	public ComputedQuestion(Ident identifier, StringLiteral label, Type type, Expr expression) {
		super(identifier, label, type);
		this.expression = expression;
	}

}
