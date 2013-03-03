package org.uva.sea.ql.ast.formelements;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.IElementVisitor;

public class CompQuestion extends Question {

	private final Expr expression;

	public CompQuestion(Ident name, StringLiteral label, Type type, Expr expression) {
		super(name, label, type);
		this.expression = expression;
	}

	public Expr getExpr() {
		return expression;
	}

	@Override
	public void accept(IElementVisitor ElementVisitor) {
		ElementVisitor.visit(this);
	}

}
