package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.visitor.StatementVisitor;

public class QuestionComputed extends QuestionDeclaration {
	private final Assignment assignment;

	public QuestionComputed( StringLiteral label, Assignment assignment ) {
		super( label );
		this.assignment = assignment;
	}

	public Assignment getAssignment() {
		return this.assignment;
	}

	public Expression getExpression() {
		return this.assignment.getExpression();
	}

	@Override
	public IdentifierExpression getIdent() {
		return this.assignment.getIdent();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
