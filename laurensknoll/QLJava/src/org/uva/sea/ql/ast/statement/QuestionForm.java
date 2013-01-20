package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.type.IdentExprType;

public class QuestionForm extends AbstractStatement {

	private final IdentExprType ident;
	private final AbstractStatement statement;

	public QuestionForm(IdentExprType ident, AbstractStatement statement) {
		this.ident = ident;
		this.statement = statement;
	}

	public IdentExprType getIdent() {
		return this.ident;
	}

	public AbstractStatement getStatements() {
		return this.statement;
	}

}
