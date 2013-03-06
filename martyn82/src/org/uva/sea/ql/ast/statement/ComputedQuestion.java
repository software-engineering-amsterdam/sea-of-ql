package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.visitor.StatementVisitor;

public class ComputedQuestion extends QuestionDeclaration {
	private final Assignment assignment;

	public ComputedQuestion( StringLiteral label, Assignment assignment ) {
		super( label );
		assert ( assignment != null );

		this.assignment = assignment;
	}

	public Assignment getAssignment() {
		return this.assignment;
	}

	public Expression getExpression() {
		return this.assignment.getExpression();
	}

	@Override
	public IdentifierExpression getIdentifier() {
		return this.assignment.getIdentifier();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
