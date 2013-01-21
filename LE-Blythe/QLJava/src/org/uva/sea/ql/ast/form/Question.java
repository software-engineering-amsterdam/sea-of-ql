package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;


public class Question extends Expr{
	
	private String sQuestion;
	private Ident pIdentifier;
	private Expr  pValue;
	
	
	public Question(String sQuestion, Ident pIdentifier, Expr pValue){
		this.sQuestion = sQuestion;
		this.pIdentifier = pIdentifier;
		this.pValue = pValue;
	}
	
	
	public Ident getIdentifier(){
		return pIdentifier;
	}
	
	
	public String getQuestion(){
		return sQuestion;
	}
	
	
	public  Expr getValue(){
		return pValue;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
