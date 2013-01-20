package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public class ComputedQuestion extends AbstractStatement {

	private final Question question;
	private final AbstractExpr computeExpression;

	public ComputedQuestion(Question question, AbstractExpr computeExpression) {
		this.question = question;
		this.computeExpression = computeExpression;
	}

	public Question getQuestion() {
		return this.question;
	}

	public AbstractExpr getComputeExpression() {
		return this.computeExpression;
	}

}
