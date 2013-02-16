package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.literal.StringLiteral;

public class ComputedQuestion extends Question {

	public final Expression expression;
	
	public ComputedQuestion(Identifier id, StringLiteral label, Expression expr) {
		// todo: find correct type
		super(id, label, null);
		this.expression = expr;
	}
}
