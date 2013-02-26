package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.StringLiteral;

public abstract class Question extends Statement {

	private final String question;
	private final Identifier identifier;

	Question(final ICodeLocationInformation info, final StringLiteral question,
			final Identifier identifier) {
		super(info);
		this.question = question.getValue();
		this.identifier = identifier;
	}

	public Identifier getIdentifier() {
		return this.identifier;
	}

	public String getQuestion() {
		return this.question;
	}
}
