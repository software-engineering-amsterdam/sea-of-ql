package org.uva.sea.ql.ast;

public class IfStmt implements ASTNode {
	private final ASTNode expression;
	private final ASTNode statements;

	public IfStmt(ASTNode expression, ASTNode statements) {
		this.expression = expression;
		this.statements = statements;
	}

	public ASTNode getExpression() {
		return expression;
	}

	public ASTNode getStatements() {
		return statements;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
