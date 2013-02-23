package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.visitor.IVisitorStatement;
import org.uva.sea.ql.ast.Statement;

public class Form extends Statement {

	private String name;
	private Block block;
	
	
	public Form(String sName, Block block){
		this.name = sName;
		this.block = block;
	}
	
	
	public Block getBlock(){
		return block;
	}
	
	
	public String getName(){
		return name;
	}

	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
