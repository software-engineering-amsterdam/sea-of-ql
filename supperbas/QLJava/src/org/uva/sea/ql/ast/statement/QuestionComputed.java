package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.value.Str;


public class QuestionComputed extends Question {

	private final Ident ident;
	private final Expression expression;

	public QuestionComputed(Str label,Ident ident, Expression expression){
		super(label);
		this.ident = ident;
		this.expression = expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Ident getIdent() {
		return ident;
	}

	public Expression getExpression() {
		return expression;
	}

}
