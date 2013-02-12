package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.questionnaire.Block;

public abstract class ConditionalStat {

	protected Expr condition;
	protected Block conditionalBlock;
	
	public ConditionalStat(Expr condition, Block ifBlock){
		this.condition = condition;
		this.conditionalBlock = ifBlock;
	}
	public abstract Block getConditionalBlock();
	
}
