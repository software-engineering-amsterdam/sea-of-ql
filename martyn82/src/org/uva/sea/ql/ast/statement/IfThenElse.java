package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.StatementVisitor;

public class IfThenElse extends IfThen {
	private final Statements elseBody;

	public IfThenElse( Expression condition, Statements ifBody, Statements elseBody ) {
		super( condition, ifBody );
		assert ( elseBody != null );

		this.elseBody = elseBody;
	}

	public Statements getElse() {
		return this.elseBody;
	}

	public boolean hasElse() {
		return this.elseBody.size() > 0;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
