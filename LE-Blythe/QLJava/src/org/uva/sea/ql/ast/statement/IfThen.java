package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;

public class IfThen extends Statement{
	
	private Expr 	  	ifCondition;
	
	private Block	 	ifBlock;
	
	
	public IfThen(Expr ifCondition, Block ifBlock){
		this.ifCondition = ifCondition;
		this.ifBlock = ifBlock;
	}
	
	
	public Expr getIfCondition(){
		return ifCondition;
	}
	
	
	public Block getIfBlock(){
		return ifBlock;
	}
	
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
