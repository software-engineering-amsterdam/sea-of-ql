package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.types.Type;

public class ComputedQuestion extends Question {
	private final Expr orExpr;

	public ComputedQuestion(Ident ident, StringLiteral strLtr, Type type, Expr orExpr) {
		super(ident, strLtr, type);
		this.orExpr = orExpr;
	}
		
	public Expr getExpr() {
		return orExpr;
	}
}