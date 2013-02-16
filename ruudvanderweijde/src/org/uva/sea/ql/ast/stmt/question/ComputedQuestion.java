package org.uva.sea.ql.ast.stmt.question;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IFormVisitor;

public class ComputedQuestion extends Question {

	private final Expr expression;
	
	public ComputedQuestion(Ident id, String label, Type tp, Expr expression) {
		super(id, label, tp);
		this.expression = expression;
	}

	public Expr getExpr() {
		return expression;
	}
	
	@Override
	public void accept(IFormVisitor visitor) {
		visitor.visit(this);
	}
}
