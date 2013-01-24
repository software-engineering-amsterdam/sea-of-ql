package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.TypeChecker;


public class IfBody extends FormElement {

	private final Expr expression;
	private final List<FormElement> ifBody;

	public IfBody(Expr expression, List<FormElement> ifBody) {
		this.expression = expression;
		this.ifBody = ifBody;
	}

	public Expr getExpression() {
		return expression;
	}

	public List<FormElement> getIfElements() {
		return ifBody;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
	}

}
