package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class IfThenStat extends ConditionalStat{

	public IfThenStat(Expr condition, Block ifBlock){
		super(condition,ifBlock);
	}
	
	@Override
	public Block getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
