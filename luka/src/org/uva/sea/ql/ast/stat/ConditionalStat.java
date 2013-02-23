package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class ConditionalStat implements Stat{
	//condition for if, if true, trueBlock needs to be shown
	protected final Expr condition;
	//block which depends on expression
	protected final Block trueBlock;
	
	public ConditionalStat(Expr condition, Block block){
		this.condition = condition;
		this.trueBlock = block;
	}
	public Block getBody(){
		return this.trueBlock;
	}
	
	public Expr getCondition(){
		return this.condition;
	}
	
	@Override
	public String toString() {
		return "ConditionalStat condition:" + this.condition.toString();
	}
	
}
