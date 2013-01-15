package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Question implements Statement {

	private final String name;
	private final String label;
	private final int lineNumber;
	private Expr expression;

	public Question(String name, String label, Expr expression, int lineNumber) {
		this.name = name;
		this.label = label;
		this.expression = expression;
		this.lineNumber = lineNumber;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public Expr getExpression() {
		return expression;
	}

	public void setExpression(Expr expression) {
		this.expression = expression;
	}

}
