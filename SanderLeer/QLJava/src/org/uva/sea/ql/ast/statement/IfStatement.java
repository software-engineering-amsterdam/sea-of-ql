package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.expression.Expression;

public class IfStatement extends BlockStatement {
	private final Expression expression;

	public IfStatement(Expression expression, StatementList statements) {
		super(statements);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
