package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Assignment extends Statement {
	private final Ident ident;
	private final Expression expression;

	public Assignment( Ident ident, Expression expression ) {
		this.ident = ident;
		this.expression = expression;
	}

	public Ident getIdent() {
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
