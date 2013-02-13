package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class ConditionalStat extends Stat{

	protected Expr condition;
	protected Block trueBlock;
	
	public ConditionalStat(Expr condition, Block block){
		this.condition = condition;
		this.trueBlock = block;
	}
	public Block getBody(){
		return this.trueBlock;
	}
	
	public Expr getExpr(){
		return this.condition;
	}
	
}
