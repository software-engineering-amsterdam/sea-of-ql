package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class If extends Statement {

	private final Statement ifBody;

	private final Expression condition;

	public If(final ICodeLocationInformation info, final Expression expression,
			final Statement ifBody) {
		super(info);
		this.condition = expression;
		this.ifBody = ifBody;
	}

	@Override
	public void accept(final IStatementVisitor visitor) {
		visitor.visit(this);
	}

	public Expression getCondition() {
		return this.condition;
	}

	public Statement getIfBody() {
		return this.ifBody;
	}
}
