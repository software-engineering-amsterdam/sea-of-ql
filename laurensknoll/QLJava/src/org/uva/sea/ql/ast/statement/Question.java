package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.type.AbstractType;

public class Question extends AbstractStatement {

	private final String ident;
	private final String question;
	private final AbstractType type;

	public Question(String ident, String question, AbstractType type) {
		this.ident = ident;
		this.question = question;
		this.type = type;
	}

	public String getQuestion() {
		return this.question;
	}

	public String getIdent() {
		return this.ident;
	}

	public AbstractType getType() {
		return this.type;
	}

}
