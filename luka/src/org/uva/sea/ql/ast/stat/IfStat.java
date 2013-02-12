package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.questionnaire.Block;

public class IfStat extends ConditionalStat{

	public IfStat(Expr condition, Block ifBlock){
		super(condition,ifBlock);
	}
	
	@Override
	public Block getConditionalBlock() {
		// TODO Auto-generated method stub
		return null;
	}

}
