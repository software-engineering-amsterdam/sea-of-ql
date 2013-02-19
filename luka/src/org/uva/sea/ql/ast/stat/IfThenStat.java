package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class IfThenStat extends ConditionalStat {

	public IfThenStat(Expr condition, Block ifBlock) {
		super(condition, ifBlock);
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "IfThenStat Expr(" + this.condition.toString() + ")";
	}
}
