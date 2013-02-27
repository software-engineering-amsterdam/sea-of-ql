package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Assignment extends Statement {
	private final IdentifierExpression identifier;
	private final Expression expression;

	public Assignment( IdentifierExpression identifier, Expression expression ) {
		assert ( identifier != null ) && ( expression != null );

		this.identifier = identifier;
		this.expression = expression;
	}

	public IdentifierExpression getIdentifier() {
		return this.identifier;
	}

	public Expression getExpression() {
		return this.expression;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
