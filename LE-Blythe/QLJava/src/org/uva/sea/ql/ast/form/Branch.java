package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;

public class Branch extends FormElement{
	
	private Expr 		ifCondition;
	private FormElement ifBody,
						elseBody;
	
	
	public Branch(Expr ifCondition, FormElement ifBody){
		this.ifCondition = ifCondition;
		this.ifBody = ifBody;
		this.elseBody = null;
	}
	
	
	public Branch(Expr ifCondition, FormElement ifBody, FormElement elseBody){
		this.ifCondition = ifCondition;
		this.ifBody = ifBody;
		this.elseBody= elseBody;
	}
	
	
	public Expr getIfCondition(){
		return ifCondition;
	}
	
	
	public FormElement getIfBody(){
		return ifBody;
	}
	
	
	public FormElement getElseBody(){
		return elseBody;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
