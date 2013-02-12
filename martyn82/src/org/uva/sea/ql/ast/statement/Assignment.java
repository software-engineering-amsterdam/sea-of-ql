package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Assignment extends Statement {
	private final IdentifierExpression ident;
	private final Expression expression;

	public Assignment( IdentifierExpression ident, Expression expression ) {
		this.ident = ident;
		this.expression = expression;
	}

	public IdentifierExpression getIdent() {
		return this.ident;
	}

	public Expression getExpression() {
		return this.expression;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
