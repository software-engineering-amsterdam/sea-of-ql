package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class ElseIfStat extends Statement {
	
	private final Expr condition;
	private final Body ifBody;

	public ElseIfStat(Expr eCond, Body eiB) {
		this.condition = eCond;
		this.ifBody = eiB;
	}
	
	public Expr getCondition() {
		return condition;
	}
	
	public Body getBody() {
		return ifBody;
	}
	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
