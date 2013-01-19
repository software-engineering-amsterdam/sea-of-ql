package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class IfBody implements FormElement {

	private final Expr expression;
	private final FormBlock ifbody;

	public IfBody(Expr expression, FormBlock ifbody) {
		this.expression = expression;
		this.ifbody = ifbody;
	}

	public Expr getExpression() {
		return expression;
	}

	public FormBlock getIfElements() {
		return ifbody;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
