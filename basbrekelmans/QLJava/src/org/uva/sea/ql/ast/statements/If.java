package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class If extends Statement {

	private final Statement ifBody;

	private final Expression expression;

	public If(final ICodeLocationInformation info, final Expression expression,
			final Statement ifBody) {
		super(info);
		this.expression = expression;
		this.ifBody = ifBody;
	}

	@Override
	public void accept(final IStatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Expression getExpression() {
		return this.expression;
	}

	public Statement getIfBody() {
		return this.ifBody;
	}

	@Override
	public boolean hasExpression() {
		return true;
	}

}
