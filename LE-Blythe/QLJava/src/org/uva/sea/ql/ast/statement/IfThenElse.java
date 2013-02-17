package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.interfaces.IVisitorStatement;

public class IfThenElse extends IfThen{
	
	private Block elseBlock;

	public IfThenElse(Expr ifCondition, Block ifBlock, Block elseBlock){
		super(ifCondition, ifBlock);
		this.elseBlock= elseBlock;
	}

	
	public Block getElseBlock(){
		return elseBlock;
	}
	
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
