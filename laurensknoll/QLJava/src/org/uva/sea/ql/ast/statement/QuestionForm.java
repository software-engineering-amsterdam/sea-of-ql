package org.uva.sea.ql.ast.statement;


public class QuestionForm extends AbstractStatement {

	private final AbstractStatement statement;

	public QuestionForm(AbstractStatement statement) {
		this.statement = statement;
	}

	public AbstractStatement getStatements() {
		return this.statement;
	}

}
