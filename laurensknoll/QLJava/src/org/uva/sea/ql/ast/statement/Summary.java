package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public class Summary extends AbstractStatement {

	private final AbstractStatement question;
	private final AbstractExpr expression;

	public Summary(AbstractStatement question, AbstractExpr expression) {
		this.question = question;
		this.expression = expression;
	}

	public AbstractStatement getQuestion() {
		return this.question;
	}

	public AbstractExpr getExpression() {
		return this.expression;
	}

}
