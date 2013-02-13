package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class ConditionalStat {

	protected Expr condition;
	protected Block trueBlock;
	
	public ConditionalStat(Expr condition, Block block){
		this.condition = condition;
		this.trueBlock = block;
	}
	public abstract Block getBody();
	
}
