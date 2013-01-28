package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.TypeChecker;

public class IfThen extends FormElement {

	private final Expr expression;
	private final Block thenBody;

	public IfThen(Expr expression, Block thenBody) {
		this.expression = expression;
		this.thenBody = thenBody;
	}

	public Expr getExpression() {
		return expression;
	}

	public Block getThenBody() {
		return thenBody;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
	}

}
