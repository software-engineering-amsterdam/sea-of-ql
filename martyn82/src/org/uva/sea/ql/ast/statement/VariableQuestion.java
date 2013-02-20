package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class VariableQuestion extends QuestionDeclaration {
	private final VariableDeclaration variableDeclaration;

	public VariableQuestion( StringLiteral label, VariableDeclaration varDeclaration ) {
		super( label );
		assert ( varDeclaration != null );

		this.variableDeclaration = varDeclaration;
	}

	public VariableDeclaration getVariableDeclaration() {
		return this.variableDeclaration;
	}

	public Type getType() {
		return this.variableDeclaration.getType();
	}

	@Override
	public IdentifierExpression getIdentifier() {
		return this.variableDeclaration.getIdentifier();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
