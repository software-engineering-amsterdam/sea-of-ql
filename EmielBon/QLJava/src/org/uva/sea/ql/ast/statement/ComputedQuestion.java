package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class ComputedQuestion extends Question {

	protected final Expression expression;
	
	public ComputedQuestion(Identifier id, StringLiteral label, Type type, Expression expr) {
		super(id, label, type);
		this.expression = expr;
	}

	public Expression getExpression() {
		return expression;
	}
	
}
