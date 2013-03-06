package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class ComputedQuestion extends FormUnit {

	private final Ident name;
	private final String body;
	private final Expr expression;
	private final Type type;
	
	public ComputedQuestion(Ident ident, String body, Expr expression, Type type) {
		this.name = ident;
		this.body = body;
		this.type = type;
		this.expression = expression;
	}

	public Ident getIdent() {
		return name;
	}

	public String getBody() {
		return body;
	}
	
	public Expr getExpression() {
		return expression;
	}

	public Type getType() {
		return type;
	}

	@Override
	public <T> T accept(VisitorStatements<T> visitor) {
		return visitor.visit(this);
	}

}
