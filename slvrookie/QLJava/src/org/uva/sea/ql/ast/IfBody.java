package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class IfBody extends FormElement {

	private final Expr expression;
	private final List<FormElement> ifbody;

	public IfBody(Expr expression, List<FormElement> ifbody) {
		this.expression = expression;
		this.ifbody = ifbody;
	}

	public Expr getExpression() {
		return expression;
	}

	public List<FormElement> getIfElements() {
		return ifbody;
	}

	@Override
	public void accept(Visitor visitor, Context context) {
		 visitor.visit(this, context);
		
	}

}
