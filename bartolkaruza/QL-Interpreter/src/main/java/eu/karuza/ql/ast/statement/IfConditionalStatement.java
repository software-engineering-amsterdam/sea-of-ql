package eu.karuza.ql.ast.statement;

import java.util.List;


import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.visitor.StatementVisitor;

public class IfConditionalStatement implements Statement {

	private static final long serialVersionUID = 8928419604109047055L;
	private List<Statement> statements;
	private Expr expression;
	private int lineNumber;
	private boolean visible;

	public IfConditionalStatement(Expr expression, List<Statement> statements, int lineNumber) {
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

	public Expr getExpr() {
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
