package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IElementVisitor;

public class ComputedQuestion extends Question {

	private final Expr expr;

	public ComputedQuestion(Ident id, StringLit label, Type type, Expr expr) {
		super(id, label, type);
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}

	@Override
	public void accept(IElementVisitor qlElement) {
		qlElement.visit(this);
	}

}
