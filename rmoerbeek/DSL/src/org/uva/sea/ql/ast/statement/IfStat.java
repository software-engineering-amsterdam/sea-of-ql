package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class IfStat extends Statement {
	
	private final Expr condition;
	private final Body ifBody;
	private final List<ElseIfStat> elseIfStats;
	private final ElseStat elseStat;

	public IfStat(Expr cond, Body iB, List<ElseIfStat> elseIfStats,
			ElseStat elseStat) {
		this.condition = cond;
		this.ifBody = iB;
		this.elseIfStats = elseIfStats;
		this.elseStat = elseStat;
	}
	
	public Expr getCondition() {
		return condition;
	}
	
	public Body getBody() {
		return ifBody;
	}
	
	public List<ElseIfStat> getElseIfs() {
		return elseIfStats;
	}
	
	public ElseStat getElseStat() {
		return elseStat;
	}
	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	

}
