package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.interfaces.IVisitor;

public class Branch extends Statement{
	
	private Expr 	  	ifCondition;
	private Block	 	ifBlock,
						elseBlock;
	
	
	public Branch(Expr ifCondition, Block ifBlock){
		this.ifCondition = ifCondition;
		this.ifBlock = ifBlock;
		this.elseBlock = null;
	}
	
	
	public Branch(Expr ifCondition, Block ifBlock, Block elseBlock){
		this.ifCondition = ifCondition;
		this.ifBlock = ifBlock;
		this.elseBlock= elseBlock;
	}
	
	
	public Expr getIfCondition(){
		return ifCondition;
	}
	
	
	public Block getIfBlock(){
		return ifBlock;
	}
	
	
	public Block getElseBlock(){
		return elseBlock;
	}
	
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
