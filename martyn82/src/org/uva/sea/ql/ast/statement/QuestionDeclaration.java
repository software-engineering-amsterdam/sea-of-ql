package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Str;

abstract public class QuestionDeclaration extends Statement {
	private final Str label;

	public QuestionDeclaration( Str label ) {
		this.label = label;
	}

	public Str getLabel() {
		return this.label;
	}

	abstract public Ident getIdent();
}
