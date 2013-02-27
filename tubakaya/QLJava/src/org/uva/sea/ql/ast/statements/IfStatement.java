package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;

public class IfStatement extends Statement {

	private final Expression expression;
	private final List<Statement> statements;

	public IfStatement(Expression expression, List<Statement> statements) {
		this.expression = expression;
		this.statements = statements;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public Expression getExpression() {
		return expression;
	}

	public List<Statement> getStatements() {
		return statements;
	}
}
