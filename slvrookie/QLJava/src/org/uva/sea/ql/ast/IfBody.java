package org.uva.sea.ql.ast;

import java.util.List;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class IfBody extends FormElement {

	private final Expr expression;
	private final List<FormElement> formelements;

	public IfBody(Expr expression, List<FormElement> formelements ) {

		this.expression = expression;
		this.formelements = formelements;

	}

	public Expr getExpression() {
		return expression;
	}

	public List<FormElement> getFormElements() {
		return formelements;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
