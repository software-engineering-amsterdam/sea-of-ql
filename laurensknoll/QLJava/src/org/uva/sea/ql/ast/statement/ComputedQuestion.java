package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.IStatement;

public class ComputedQuestion extends AbstractStatement {

	private final Question question;
	private final AbstractExpr computation;

	public ComputedQuestion(Question question, AbstractExpr computation) {
		this.question = question;
		this.computation = computation;
	}

	public Question getQuestion() {
		return this.question;
	}

	public AbstractExpr getComputation() {
		return this.computation;
	}

	@Override
	public <T> T accept(IStatement<T> visitor) {
		return visitor.visit(this);
	}

}
