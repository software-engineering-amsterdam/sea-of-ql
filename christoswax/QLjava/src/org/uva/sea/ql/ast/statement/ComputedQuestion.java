package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.Type;

/* refactored: extends Question, do the others also */
public class ComputedQuestion extends Question {
	private final Expr expr;

	public ComputedQuestion(Ident ident, StringLiteral str, Type type, Expr expr) {
		super(ident, str, type);
		this.expr = expr;
	}

	public Expr getExpression() {
		return expr;
	}
}
