package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Computed extends Question {
	private final Expr expression;
	
	public Computed(Ident name, String label, Type type,
			Expr expression)
	{
		super(name, label, type);
		this.expression = expression;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}