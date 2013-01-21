package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.Statement;

public class If extends AbstractStatement {

	private final AbstractExpr condition;
	private final AbstractStatement truePath;

	public If(AbstractExpr condition, AbstractStatement truePath) {
		this.condition = condition;
		this.truePath = truePath;
	}

	public AbstractStatement getTruePath() {
		return this.truePath;
	}

	public AbstractExpr getCondition() {
		return this.condition;
	}

	@Override
	public void accept(Statement<?> visitor) {
		visitor.visit(this);
	}

}
