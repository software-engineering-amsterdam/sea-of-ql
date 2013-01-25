package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.String;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.Statement;

public class Question extends AbstractStatement {

	private final Ident ident;
	private final String question;
	private final AbstractType type;

	public Question(Ident ident, String question, AbstractType type) {
		this.ident = ident;
		this.question = question;
		this.type = type;
	}

	public String getQuestion() {
		return this.question;
	}

	public Ident getIdent() {
		return this.ident;
	}

	public AbstractType getType() {
		return this.type;
	}

	@Override
	public <T> T accept(Statement<T> visitor) {
		return visitor.visit(this);
	}

}
