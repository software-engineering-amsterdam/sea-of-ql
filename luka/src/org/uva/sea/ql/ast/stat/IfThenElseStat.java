package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class IfThenElseStat extends ConditionalStat{
	private Block elseBlock;
	
	public IfThenElseStat(Expr condition, Block ifBlock, Block elseBlock){
		super(condition,ifBlock);
		this.elseBlock = elseBlock;
	}
	@Override
	public Block getBody() {
		return	this.trueBlock;
	}
	
	public Block getElseBody(){
		return this.elseBlock;
	}
	@Override
	public void accept(StatementVisitor visitor) {
		 visitor.visit(this);
	}

}
