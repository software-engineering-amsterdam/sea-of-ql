package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.StatementVisitor;

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

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}
