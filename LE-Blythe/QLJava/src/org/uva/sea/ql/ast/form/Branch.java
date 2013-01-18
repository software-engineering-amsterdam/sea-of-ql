package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;

public class Branch extends Expr{
	
	private Expr 	pIfCondition,
					pIfBody,
					pElseBody;
	
	
	public Branch(Expr pIfCondition, Expr pIfBody){
		this.pIfCondition = pIfCondition;
		this.pIfBody = pIfBody;
		this.pElseBody = null;
	}
	
	
	public Branch(Expr pIfCondition, Expr pIfBody, Expr pElseBody){
		this.pIfCondition = pIfCondition;
		this.pIfBody = pIfBody;
		this.pElseBody = pElseBody;
	}
	
	
	public Expr getIfCondition(){
		return pIfCondition;
	}
	
	
	public Expr getIfBody(){
		return pIfBody;
	}
	
	
	public Expr getElseBody(){
		return pElseBody;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
