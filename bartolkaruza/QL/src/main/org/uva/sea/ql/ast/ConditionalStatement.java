package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.visitor.StatementVisitor;

public class ConditionalStatement implements Statement {

	private List<Statement> statements;
	private Expr expression;
	private int lineNumber;

	public ConditionalStatement(Expr expression, List<Statement> statements, int lineNumber) {
		this.statements = statements;
		this.expression = expression;
		this.lineNumber = lineNumber;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public Expr getExpression() {
		return expression;
	}

	public int getLineNumber() {
		return lineNumber;
	}
}
