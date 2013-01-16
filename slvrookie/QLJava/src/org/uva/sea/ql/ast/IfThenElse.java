package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class IfThenElse extends FormElement {

	private final Expr expression;
	private final FormBlock thenBody;
	private final FormBlock elseBody;

	public IfThenElse(Expr expression, FormBlock thenBody, FormBlock elseBody) {

		this.expression = expression;
		this.thenBody = thenBody;
		this.elseBody = elseBody;

	}

	public Expr getExpression() {
		return expression;
	}

	public FormBlock getThenBody() {
		return thenBody;
	}

	public FormBlock getElseBody() {
		return elseBody;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
