package eu.karuza.ql.ast;

import java.util.List;


import eu.karuza.ql.ast.expr.grouping.Expr;
import eu.karuza.ql.visitor.StatementVisitor;

public class ConditionalStatement implements Statement {

	private static final long serialVersionUID = 8928419604109047055L;
	private List<Statement> statements;
	private Expr expression;
	private int lineNumber;
	private boolean visible;

	public ConditionalStatement(Expr expression, List<Statement> statements, int lineNumber) {
		this.statements = statements;
		this.expression = expression;
		this.lineNumber = lineNumber;
	}

	@Override
	public void accept(StatementVisitor<?> visitor) {
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
