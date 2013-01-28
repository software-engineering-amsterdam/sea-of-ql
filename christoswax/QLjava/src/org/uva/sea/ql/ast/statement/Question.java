package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.*;

public class Question extends Statement {
	private final Ident ident;
	private final StringLiteral str;
	private final Type type;

	public Question(Ident ident, StringLiteral str, Type type) {
		this.ident = ident;
		this.str = str;
		this.type = type;
	}
}