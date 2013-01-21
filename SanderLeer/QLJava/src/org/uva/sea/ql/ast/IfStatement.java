package org.uva.sea.ql.ast;

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
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
