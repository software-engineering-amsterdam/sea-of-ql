package org.uva.sea.ql.ast.stat;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.visitor.StatementVisitor;


public class Block{ // implements StatementVisitor<Boolean>
	//TODO maybe needs own visitor for underlying stats ?!
	private List<Stat> statements;
	
	public Block(){
		statements = new ArrayList<Stat>();
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
	
	public Boolean accept(StatementVisitor<Boolean> visitor){
		boolean returnValue = true;
		//for each statement, check and return
//		for(Stat s : statements){
//			boolean statementValid = s.accept(this);
//			if(!statementValid){
//				returnValue = statementValid;
//			}
//		}
		return returnValue;
	}

//	@Override
//	public Boolean visit(ComputedStat stat) {
//		// TODO Auto-generated method stub
//		//return true;
//		
//	}
//	@Override
//	public Boolean visit(AnswerableStat stat) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public Boolean visit(IfThenStat stat) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public Boolean visit(IfThenElseStat stat) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public Boolean visit(Block stat) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
