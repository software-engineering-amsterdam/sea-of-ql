package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.StatementVisitor;

public class IfThen extends Statement {
	private final Expression condition;
	private final Statements ifBody;

	public IfThen( Expression condition, Statements ifBody ) {
		assert ( condition != null ) && ( ifBody != null );

		this.condition = condition;
		this.ifBody = ifBody;
	}

	public Expression getCondition() {
		return this.condition;
	}

	public Statements getBody() {
		return this.ifBody;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}

}
