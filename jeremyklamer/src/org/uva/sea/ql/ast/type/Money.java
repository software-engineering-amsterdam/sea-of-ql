package org.uva.sea.ql.ast.type;

public class Money extends Type {
	
	private final int amount; 

	public Money(int amount){
		this.amount = amount;
	}
	
	public int getAmount(){
		return this.amount;
	}

}
