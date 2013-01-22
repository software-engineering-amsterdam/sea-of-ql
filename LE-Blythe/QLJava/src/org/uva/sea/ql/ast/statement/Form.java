package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.interfaces.IVisitor;

public class Form extends Statement {

	private String name;
	private Statement block;
	
	
	public Form(String sName, Statement block){
		this.name = sName;
		this.block = block;
	}
	
	
	public Statement getBlock(){
		return block;
	}
	
	
	public String getName(){
		return name;
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
