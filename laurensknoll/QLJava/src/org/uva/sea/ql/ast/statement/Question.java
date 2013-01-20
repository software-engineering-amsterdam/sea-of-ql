package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.answertype.AbstractAnswerType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;

public class Question extends AbstractStatement {

	private final IdentExprType ident;
	private final StringExprType question;
	private final AbstractAnswerType type;

	public Question(IdentExprType ident, StringExprType question, AbstractAnswerType type) {
		this.ident = ident;
		this.question = question;
		this.type = type;
	}

	public StringExprType getQuestion() {
		return this.question;
	}

	public IdentExprType getIdent() {
		return this.ident;
	}

	public AbstractAnswerType getType() {
		return this.type;
	}

}
