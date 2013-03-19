package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class ComputedQuestion extends Question{

	private final Expr expression;

	public ComputedQuestion(Ident id, String l, Type t, Expr e) {
		super(id, l, t);
		this.expression = e;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
	public Expr getExpression() {
		return expression;
	}

}
