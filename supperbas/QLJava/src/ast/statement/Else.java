package ast.statement;

import ast.Statement;

public class Else extends Statement {
	
	private final Block block;
	
	public Else(Block block){
		this.block = block;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public Block getBlock(){
		return this.block;
	}
}
