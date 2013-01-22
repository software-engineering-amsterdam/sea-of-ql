package org.uva.sea.ql.ast;

public class ComputedQuestion extends Question {
	// the expression that computes the result of this question
	private final Expression expression;
	
	public ComputedQuestion(Identifier identifier, StringLiteral label, Datatype datatype, Expression expression) {
		super(identifier, label, datatype);
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
