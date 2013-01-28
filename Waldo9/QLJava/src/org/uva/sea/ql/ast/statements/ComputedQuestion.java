package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class ComputedQuestion extends Question {
	
	private final Expr expression;
	
	public ComputedQuestion(Ident identifier, StringLiteral label, Type type, Expr expression) {
		super(identifier, label, type);
		this.expression = expression;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
    }

}
