package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class ComputedQuestion extends Question {

	public final Expression expression;
	
	public ComputedQuestion(Identifier id, StringLiteral label, Type type, Expression expr) {
		super(id, label, type);
		this.expression = expr;
	}
	
}
