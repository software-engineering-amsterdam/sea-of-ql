package org.uva.sea.ql.questionnaire;

import java.util.List;

import org.uva.sea.ql.ast.stat.Stat;

public class Block {

	private List<Stat> statements;
	public Block(){
		
	}
	public Block(List<Stat> stats){
		this.statements = stats;
	}
	
	public List<Stat> getStatements(){
		return this.statements;
	}
	
	public void addStatement(Stat stat){
		this.statements.add(stat);
	}
	
	public void setStatements(List<Stat> stats){
		this.statements = stats;
	}
	
}
