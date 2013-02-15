package org.uva.sea.ql.ast.stat;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.visitor.StatementVisitor;


public class Block implements Stat{ 
	
	private List<Stat> statements;
	
	public Block(){
		statements = new ArrayList<Stat>();
	}
	
	public Block(List<Stat> stats){
		this.statements = stats;
	}
	
	@Override
	public void accept(StatementVisitor visitor) {
		 visitor.visit(this);
	}
	
	
	
	public List<Stat> getStatements(){
		return this.statements;
	}
	
	public void addStatement(Stat stat){
		this.statements.add(stat);
	}
	
	
}
