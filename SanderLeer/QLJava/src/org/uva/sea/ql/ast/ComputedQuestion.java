package org.uva.sea.ql.ast;

public class ComputedQuestion extends Question {
	private final ASTNode expression;
	
	public ComputedQuestion(Identifier identifier, StringValue label, Datatype datatype, ASTNode expression) {
		super(identifier, label, datatype);
		this.expression = expression;
	}

	public ASTNode getExpression() {
		return expression;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
