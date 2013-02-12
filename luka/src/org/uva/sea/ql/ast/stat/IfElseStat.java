package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.questionnaire.Block;

public class IfElseStat extends ConditionalStat{

	public IfElseStat(Expr condition, Block ifBlock, Block elseBlock){
		super(condition,ifBlock);
	}
	@Override
	public Block getConditionalBlock() {
		// TODO Auto-generated method stub
		return null;
	}

}
