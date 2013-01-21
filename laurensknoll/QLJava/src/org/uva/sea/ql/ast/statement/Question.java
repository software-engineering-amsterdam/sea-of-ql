package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.answertype.AbstractAnswerType;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.String;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Question extends AbstractStatement {

	private final Ident ident;
	private final String question;
	private final AbstractAnswerType type;

	public Question(Ident ident, String question,
			AbstractAnswerType type) {
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

	public AbstractAnswerType getType() {
		return this.type;
	}

	@Override
	public void accept(StatementVisitor<?> visitor) {
		visitor.visit(this);
	}

}
