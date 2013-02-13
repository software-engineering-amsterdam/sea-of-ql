package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public class IfThenStat extends ConditionalStat{

	public IfThenStat(Expr condition, Block ifBlock){
		super(condition,ifBlock);
	}
	
	@Override
	public Block getBody() {
		// TODO Auto-generated method stub
		return null;
	}

}
