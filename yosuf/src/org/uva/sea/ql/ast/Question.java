package org.uva.sea.ql.ast;

public class Question implements ASTNode {
	private final StringLiteral questionText;

	public Question(final ASTNode astNode, final ASTNode astNode2,
			final StringLiteral questionText) {
		this.questionText = questionText;
	}

	public StringLiteral getQuestionText() {
		return questionText;
	}
}
