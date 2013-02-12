package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;

abstract public class QuestionDeclaration extends Statement {
	private final StringLiteral label;

	public QuestionDeclaration( StringLiteral label ) {
		this.label = label;
	}

	public StringLiteral getLabel() {
		return this.label;
	}

	abstract public IdentifierExpression getIdent();
}
