package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.Block;

public class Form implements ASTNode, IVisitableStatement {

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
